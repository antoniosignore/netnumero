package com.numhero.server.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.pojoc.*;
import com.numhero.client.util.ClientUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.enums.AccountingEntrySide;
import com.numhero.shared.enums.BusinessTransactionEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.ReferenceDocEnum;
import com.numhero.shared.pojoc.field.OwnedListField;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.*;

public class DoubleEntryProcessorTest {

    private DoubleEntryProcessor dep;

    @Before
    public void Setup() {
        dep = new DoubleEntryProcessor();
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        injector.injectMembers(dep);

        when(dep.fxDao.convertToOtherCurrency(anyDouble(), any(CurrencyEnum.class), any(CurrencyEnum.class))).thenCallRealMethod();
        when(dep.fxDao.getExchangeRate(any(CurrencyEnum.class), any(CurrencyEnum.class))).thenReturn(1.5);
        when(dep.taxInfoDao.get(1L)).thenReturn(PojoTestUtils.createPercentTaxInfo());

        when(dep.taxInfoDao.get(11L)).thenReturn(PojoTestUtils.createVatTaxInfo(20.0));
        when(dep.taxInfoDao.get(12L)).thenReturn(PojoTestUtils.createVatTaxInfo(10.0));
        when(dep.taxInfoDao.get(13L)).thenReturn(PojoTestUtils.createVatTaxInfo(5.0));
        when(dep.taxInfoDao.get(14L)).thenReturn(PojoTestUtils.createVatTaxInfo(17.5));

        doAnswer(new Answer<NominalLedgerAccount>() {
            @Override
            public NominalLedgerAccount answer(InvocationOnMock invocationOnMock) throws Throwable {

                NominalLedgerAccount ac = new NominalLedgerAccount();
                ac.fCode.setValue((String) invocationOnMock.getArguments()[1]);
                ac.fName.setValue((String) invocationOnMock.getArguments()[1]);
                ac.fId.setValue(1L);
                return ac;
            }
        }).when(dep.nominalLedgerAccountDao).loadAccountsByCode(eq("ba1"), anyString());

        when(dep.bankAccountDao.get(100L)).thenReturn(PojoTestUtils.createBankAccount());

        when(dep.categoryDao.get(1L)).thenReturn(PojoTestUtils.createCategory());
        Category cat2 = PojoTestUtils.createCategory();
        cat2.fName.setValue(CompanyBuilder.CAT_OFFICE_SUPPLIES);
        when(dep.categoryDao.get(2L)).thenReturn(cat2);


        List<BusinessTransaction> lbt = new ArrayList<BusinessTransaction>();
        lbt.add(PojoTestUtils.createAccountingEntry());
        lbt.add(PojoTestUtils.createAccountingEntry());
        when(dep.businessTransactionDao.findByDocRelation(anyString(), anyLong(), any(ReferenceDocEnum.class))).thenReturn(lbt);
    }


    @Test
    public void testProcessSaleToClient() throws Exception {

        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        Invoice inv = PojoTestUtils.createInvoiceVAT();

        dep.processSaleToClient(ba, inv);

        verify(dep.nominalLedgerAccountDao, times(1)).loadAccountsByCode(eq("ba1"), anyString());
        verify(dep.clientSupplierDao, times(1)).get(21L);

        verify(dep.businessTransactionDao, times(1)).save(correctSaleToClient(2000.0, simpleTax(350.0)));

        verify(dep.businessTransactionDao, times(1)).findByDocRelation("ba1", 42L, ReferenceDocEnum.Invoice);
        verify(dep.businessTransactionDao, times(2)).delete(anyLong());
    }

    private Map<String, Double> simpleTax(double sum) {
        Map<String, Double> taxes = new HashMap<String, Double>();
        if (sum != 0) {
            taxes.put("VAT175", sum);
        }
        return taxes;
    }


    @Test
    public void testProcessMultiVatSaleToClient() throws Exception {

        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        Invoice inv = PojoTestUtils.createInvoiceMultiVAT();

        dep.processSaleToClient(ba, inv);

        verify(dep.nominalLedgerAccountDao, times(1)).loadAccountsByCode(eq("ba1"), anyString());
        verify(dep.taxInfoDao, times(4)).get(anyLong());

        verify(dep.clientSupplierDao, times(1)).get(21L);

        Map<String, Double> taxes = new HashMap<String, Double>();
        taxes.put("VAT20.0", 200.0);
        taxes.put("VAT10.0", 180.0);
        taxes.put("VAT5.0", 40.0);
        taxes.put("VAT17.5", 105.0);


        verify(dep.businessTransactionDao, times(1)).save(correctSaleToClient(2400.0, taxes));
    }


    @Test
    public void testProcessCurrencySaleToClient() throws Exception {

        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        Invoice inv = PojoTestUtils.createInvoiceUSD();

        dep.processSaleToClient(ba, inv);

        verify(dep.clientSupplierDao, times(1)).get(21L);

        verify(dep.nominalLedgerAccountDao, times(1)).loadAccountsByCode(eq("ba1"), anyString());

        verify(dep.businessTransactionDao, times(1)).save(correctSaleToClient(3000.0, simpleTax(525.0))); //USD = 1.5
    }

    @Test
    public void testProcessNoVatSaleToClient() throws Exception {

        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        Invoice inv = PojoTestUtils.createInvoiceNoVat();

        dep.processSaleToClient(ba, inv);

        verify(dep.nominalLedgerAccountDao, times(1)).loadAccountsByCode(eq("ba1"), anyString());

        verify(dep.clientSupplierDao, times(1)).get(21L);

        verify(dep.businessTransactionDao, times(1)).save(correctSaleToClient(2000.0, simpleTax(0)));
    }


    private BusinessTransaction correctSaleToClient(final double net, final Map<String, Double> taxes) {
        return argThat(new ArgumentMatcher<BusinessTransaction>() {
            @Override
            public boolean matches(Object o) {
                BusinessTransaction bt = (BusinessTransaction) o;


                return isSaleToClientOk(bt, taxes, net);
            }
        });
    }

    private boolean isSaleToClientOk(BusinessTransaction bt, Map<String, Double> taxes, double net) {
        if (!bt.fName.getValue().equals("Invoice 2010/1")
                || !bt.fBusinessAccountUri.getValue().equals("ba1")
                || !bt.fDescription.getValue().equals("Sale to Client: Jim Walls & Co")) {
            System.err.println("bt.fName.getValue() " + bt.fName.getValue());
            System.err.println("bt.fDescription.getValue() " + bt.fDescription.getValue());

            return false;
        }


        if (bt.fBusinessTransaction.getValue() != BusinessTransactionEnum.SaleToClient) {
            System.err.println("bt.fBusinessTransaction.getValue() " + bt.fBusinessTransaction.getValue());
            return false;
        }


        if (bt.fReferenceDocId.getValue().longValue() != 42L) {
            System.err.println("bt.fReferenceDocId.getValue() " + bt.fReferenceDocId.getValue());
            return false;
        }

        if (!bt.fReferenceDocName.getValue().equals("2010/1")) {
            System.err.println("bt.fReferenceDocName.getValue() " + bt.fReferenceDocName.getValue());
            return false;
        }

        if (bt.fReferenceDocType.getValue() != ReferenceDocEnum.Invoice) {
            System.err.println("bt.fReferenceDocType.getValue() " + bt.fReferenceDocType.getValue());
            return false;
        }


        OwnedListField<AccountingLeg> legs = bt.getAccountingLegs();
        double vat = ClientUtils.calculateSumOfDoubles(taxes.values());
        //System.out.println("total vat " +vat);

        double total = net + vat;

        if (wrongLeg(legs.get(0), "ACCOUNTS_RECEIVABLE", "Jim Walls & Co", total, AccountingEntrySide.debit)) {
            return false;
        }
        if (wrongLeg(legs.get(1), "SALES", "SALES", net, AccountingEntrySide.credit)) {
            return false;
        }


        if (legs.size() != taxes.size() + 2) {
            System.err.println("bt.getAccountingLegs().size() " + legs.size());
            return false;
        }
        for (int i = 2; i < legs.size(); i++) {

            AccountingLeg accountingLeg = legs.get(i);

            String taxname = accountingLeg.fAccountName.getValue();
            double taxamount = taxes.get(taxname);
            if (wrongLeg(accountingLeg, "VAT", taxname, taxamount, AccountingEntrySide.credit)) {
                return false;
            }
        }


        return true;
    }

    private boolean wrongLeg(AccountingLeg leg, String nominalCode, String accountName, double value, AccountingEntrySide type) {
        if (!leg.fAccountName.getValue().equals(accountName)) {
            System.out.println("wrongLeg.fAccountName " + leg.fAccountName.getValue() + " expected:" + accountName + "  on leg " + leg.toString());
            return true;
        }
        if (!leg.fNominalCode.getValue().equals(nominalCode)) {
            System.out.println("wrongLeg.fNominalCode " + leg.fNominalCode.getValue() + "  on leg " + leg.toString());
            return true;
        }
        if (!leg.fValue.getValue().equals(value)) {
            System.out.println("wrongLeg.fValue " + leg.fValue.getValue() + " expected " + value + "  on leg" + leg.toString());
            return true;
        }
        if (!leg.fDoubleEntryType.getValue().equals(type)) {
            System.out.println("wrongLeg.fDoubleEntryType " + leg.fDoubleEntryType.getValue() + " expected " + type + "  on leg " + leg.toString());
            return true;
        }
        return false;
    }

    @Test
    public void testCalculate() throws Exception {
        Invoice inv = PojoTestUtils.createInvoice();
        double n = inv.calculateNet();
        Map<Long, TaxInfo> lTaxes = dep.taxInfoDao.findAllFromInvoice(inv);
        Map<String, Double> t1 = inv.calculateTaxes(lTaxes);
        double t = ClientUtils.calculateSumOfDoubles(t1.values());
        verify(dep.taxInfoDao, times(1)).get(1L);

        double approx = 0.001;
        assertEquals(60000.0, n, approx);
        assertEquals(n * 0.175, t, approx);
        assertEquals(70500, inv.getPrice(), approx);
    }

    @Test
    public void testCalculateDiscount() throws Exception {
        Invoice inv = PojoTestUtils.createInvoice();
        inv.fDiscount.setValue(50.0);


        double n = inv.calculateNet();
        Map<Long, TaxInfo> lTaxes = dep.taxInfoDao.findAllFromInvoice(inv);
        Map<String, Double> t1 = inv.calculateTaxes(lTaxes);
        double t = ClientUtils.calculateSumOfDoubles(t1.values());
        verify(dep.taxInfoDao, times(1)).get(1L);

        double approx = 0.001;
        assertEquals(30000.0, n, approx);
        assertEquals(n * 0.175, t, approx);
        assertEquals(70500, inv.getPrice(), approx);
    }

    @Test
    public void testProcessClientPayment() throws Exception {
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        Invoice inv = PojoTestUtils.createInvoice();

        dep.processPaymentFromClient(ba, inv);

        verify(dep.nominalLedgerAccountDao, times(1)).loadAccountsByCode(eq("ba1"), anyString());

        verify(dep.clientSupplierDao, times(1)).get(21L);

        verify(dep.businessTransactionDao, times(1)).save(correctClientPayment());
    }

    @Test
    public void testProcessDirectPayment() throws Exception {
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();

        BankTransaction bt = PojoTestUtils.createBankTransaction();
        dep.processDirectPayment(ba, bt);

        verify(dep.categoryDao, times(1)).get(1L);
        verify(dep.bankAccountDao, times(1)).get(100L);

        verify(dep.businessTransactionDao, times(1)).save(correctDirectPayment(2345.0));
        verify(dep.businessTransactionDao, times(1)).findByDocRelation("ba1", 111L, ReferenceDocEnum.BankTransaction);
        verify(dep.businessTransactionDao, times(2)).delete(anyLong());
    }

    @Test
    public void testProcessReimbursementsPayment() throws Exception {
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();

        BankTransaction bt = PojoTestUtils.createBankTransaction();
        Map<Category, Double> rmap = PojoTestUtils.createReceipts();
        dep.processReimbursementsPayment(ba, bt, rmap);

        double tot = ClientUtils.calculateSumOfDoubles(rmap.values());

        assertThat(bt.fValue.getValue(), is(tot));

        verify(dep.categoryDao, times(0)).get(1L);
        verify(dep.bankAccountDao, times(1)).get(100L);

        verify(dep.businessTransactionDao, times(1)).save(correctReimbursementsPayment(rmap));

        verify(dep.businessTransactionDao, times(1)).findByDocRelation("ba1", 111L, ReferenceDocEnum.BankTransaction);
        verify(dep.businessTransactionDao, times(2)).delete(anyLong());
    }

    private BusinessTransaction correctReimbursementsPayment(final Map<Category, Double> rmap) {
        return argThat(new ArgumentMatcher<BusinessTransaction>() {
            @Override
            public boolean matches(Object o) {
                return isReimbursementPaymentOk((BusinessTransaction) o, rmap);
            }
        });
    }

    private boolean isReimbursementPaymentOk(BusinessTransaction bt, Map<Category, Double> rmap) {
        if (!bt.fName.getValue().equals("Payment Bank Transaction 111")) {
            System.err.println("bt.fName.getValue() " + bt.fName.getValue());
            return false;
        }
        if (!bt.fBusinessAccountUri.getValue().equals("ba1")) {
            System.err.println("bt.fBusinessAccountUri.getValue() " + bt.fBusinessAccountUri.getValue());
            return false;
        }
        if (!bt.fDescription.getValue().equals("Payment for reimbursements")) {
            System.err.println("bt.fDescription.getValue() " + bt.fDescription.getValue());
            return false;
        }
        if (bt.fBusinessTransaction.getValue() != BusinessTransactionEnum.ReimbursementsPayment) {
            System.err.println("bt.fBusinessTransaction.getValue() " + bt.fBusinessTransaction.getValue());
            return false;
        }


        if (bt.fReferenceDocId.getValue() != 111L) {
            System.err.println("bt.fReferenceDocId.getValue() " + bt.fReferenceDocId.getValue());
            return false;
        }

        if (!bt.fReferenceDocName.getValue().equals("Phone bill")) {
            System.err.println("bt.fReferenceDocName.getValue() " + bt.fReferenceDocName.getValue());
            return false;
        }

        if (bt.fReferenceDocType.getValue() != ReferenceDocEnum.BankTransaction) {
            System.err.println("bt.fReferenceDocType.getValue() " + bt.fReferenceDocType.getValue());
            return false;
        }

        OwnedListField<AccountingLeg> legs = bt.getAccountingLegs();
        if (legs.size() != 3) {
            System.err.println("bt.getAccountingLegs().size() " + legs.size());
            return false;
        }


        double tot = ClientUtils.calculateSumOfDoubles(rmap.values());


        if (wrongLeg(legs.get(0), "BANK", "My bank", tot, AccountingEntrySide.debit)) {
            return false;
        }


        if (wrongLeg(legs.get(1), "MISCELLANEOUS_EXPENSES", "Telephone", 2000.0, AccountingEntrySide.credit)) {
            return false;
        }

        if (wrongLeg(legs.get(2), "MISCELLANEOUS_EXPENSES", "Taxi", 345.0, AccountingEntrySide.credit)) {
            return false;
        }
        return true;  //To change body of created methods use File | Settings | File Templates.
    }

    @Test
    public void testProcessExpense() throws Exception {
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        Invoice exp = PojoTestUtils.createExpense();
        exp.setId(21L);


        dep.processPurchaseFromSupplier(ba, exp);

        verify(dep.categoryDao, times(1)).get(anyLong());

        verify(dep.clientSupplierDao, times(1)).get(22L);
        verify(dep.businessTransactionDao, times(1)).save(correctExpenseFromSupplier(6000.0, simpleTax(1050.0)));

        verify(dep.businessTransactionDao, times(1)).findByDocRelation("ba1", 21L, ReferenceDocEnum.Expense);
        verify(dep.businessTransactionDao, times(2)).delete(anyLong());

    }

    private BusinessTransaction correctExpenseFromSupplier(final double net, final Map<String, Double> taxes) {
        return argThat(new ArgumentMatcher<BusinessTransaction>() {
            @Override
            public boolean matches(Object o) {
                return isExpenseFromSupplierOk((BusinessTransaction) o, net, taxes);
            }
        });
    }

    private boolean isExpenseFromSupplierOk(BusinessTransaction bt, double net, Map<String, Double> taxes) {

        if (!bt.fName.getValue().equals("Expense 111")) {
            System.err.println("tmp.fName.getValue() " + bt.fName.getValue());
            return false;
        }
        if (!bt.fBusinessAccountUri.getValue().equals("ba1")) {
            System.err.println("tmp.fBusinessAccountUri.getValue() " + bt.fBusinessAccountUri.getValue());
            return false;
        }
        if (!bt.fDescription.getValue().equals("Purchase from Supplier: Bauhaus")) {
            System.err.println("tmp.fDescription.getValue() " + bt.fDescription.getValue());
            return false;
        }
        if (bt.fBusinessTransaction.getValue() != BusinessTransactionEnum.SupplierExpense) {
            System.err.println("tmp.fBusinessTransaction.getValue() " + bt.fBusinessTransaction.getValue());
            return false;
        }


        if (bt.fReferenceDocId.getValue() != 21L) {
            System.err.println("bt.fReferenceDocId.getValue() " + bt.fReferenceDocId.getValue());
            return false;
        }

        if (!bt.fReferenceDocName.getValue().equals("111")) {
            System.err.println("bt.fReferenceDocName.getValue() " + bt.fReferenceDocName.getValue());
            return false;
        }

        if (bt.fReferenceDocType.getValue() != ReferenceDocEnum.Expense) {
            System.err.println("bt.fReferenceDocType.getValue() " + bt.fReferenceDocType.getValue());
            return false;
        }
        OwnedListField<AccountingLeg> legs = bt.getAccountingLegs();
        double vat = ClientUtils.calculateSumOfDoubles(taxes.values());

        double total = net + vat;
//        System.out.println("total net vat " +total +" " + net + " " +vat);

        if (wrongLeg(legs.get(0), CompanyBuilder.ACCOUNTS_PAYABLE, "Bauhaus", total, AccountingEntrySide.debit)) {
            return false;
        }
        if (wrongLeg(legs.get(1), CompanyBuilder.PURCHASES, CompanyBuilder.CAT_OFFICE_SUPPLIES, net, AccountingEntrySide.credit)) {
            return false;
        }


        if (legs.size() != taxes.size() + 2) {
            System.err.println("tmp.getAccountingLegs().size() " + legs.size());
            return false;
        }
        for (int i = 2; i < legs.size(); i++) {

            AccountingLeg accountingLeg = legs.get(i);

            String taxname = accountingLeg.fAccountName.getValue();
            double taxamount = taxes.get(taxname);
            if (wrongLeg(accountingLeg, "VAT", taxname, taxamount, AccountingEntrySide.credit)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testProcessExpensePayment() throws Exception {

        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        Invoice exp = PojoTestUtils.createExpense();
        exp.setId(21L);


        dep.processPaymentToSupplier(ba, exp);

        verify(dep.nominalLedgerAccountDao, times(1)).loadAccountsByCode(eq("ba1"), anyString());
        verify(dep.clientSupplierDao, times(1)).get(22L);

        verify(dep.businessTransactionDao, times(1)).save(correctExpensePayment(7050.0));
    }

    private BusinessTransaction correctExpensePayment(final double amount) {
        return argThat(new ArgumentMatcher<BusinessTransaction>() {
            @Override
            public boolean matches(Object o) {

                return isExpensePaymentOk((BusinessTransaction) o, amount);
            }
        });
    }

    private boolean isExpensePaymentOk(BusinessTransaction bt, double amount) {
        if (!bt.fName.getValue().equals("111")
                || !bt.fBusinessAccountUri.getValue().equals("ba1")
                || !bt.fDescription.getValue().equals("Payment to supplier: Bauhaus")) {
            System.err.println("tmp.fName.getValue() " + bt.fName.getValue());
            System.err.println("tmp.fDescription.getValue() " + bt.fDescription.getValue());

            return false;
        }


        if (bt.fBusinessTransaction.getValue() != BusinessTransactionEnum.SupplierPayment) {
            System.err.println("bt.fBusinessTransaction.getValue() " + bt.fBusinessTransaction.getValue());
            return false;
        }


        if (bt.fReferenceDocId.getValue() != 21L) {
            System.err.println("tmp.fReferenceDocId.getValue() " + bt.fReferenceDocId.getValue());
            return false;
        }

        if (!bt.fReferenceDocName.getValue().equals("111")) {
            System.err.println("tmp.fReferenceDocName.getValue() " + bt.fReferenceDocName.getValue());
            return false;
        }

        if (bt.fReferenceDocType.getValue() != ReferenceDocEnum.Expense) {
            System.err.println("tmp.fReferenceDocType.getValue() " + bt.fReferenceDocType.getValue());
            return false;
        }

        OwnedListField<AccountingLeg> legs = bt.getAccountingLegs();
        if (legs.size() != 2) {
            System.err.println("tmp.getAccountingLegs().size() " + legs.size());
            return false;
        }

        if (wrongLeg(legs.get(0), "BANK", "BANK", amount, AccountingEntrySide.debit)) {
            return false;
        }
        if (wrongLeg(legs.get(1), "ACCOUNTS_PAYABLE", "Bauhaus", amount, AccountingEntrySide.credit)) {
            return false;
        }
        return true;
    }


    private BusinessTransaction correctDirectPayment(final double amount) {
        return argThat(new ArgumentMatcher<BusinessTransaction>() {
            @Override
            public boolean matches(Object o) {
                return isDirectPaymentOk((BusinessTransaction) o, amount);
            }
        });
    }

    private boolean isDirectPaymentOk(BusinessTransaction bt, double amount) {
        if (!bt.fName.getValue().equals("Payment Bank Transaction 111")) {
            System.err.println("tmp.fName.getValue() " + bt.fName.getValue());
            return false;
        }
        if (!bt.fBusinessAccountUri.getValue().equals("ba1")) {
            System.err.println("tmp.fBusinessAccountUri.getValue() " + bt.fBusinessAccountUri.getValue());
            return false;
        }
        if (!bt.fDescription.getValue().equals("Payment for: Telephone")) {
            System.err.println("tmp.fDescription.getValue() " + bt.fDescription.getValue());
            return false;
        }
        if (bt.fBusinessTransaction.getValue() != BusinessTransactionEnum.DirectPayment) {
            System.err.println("tmp.fBusinessTransaction.getValue() " + bt.fBusinessTransaction.getValue());
            return false;
        }

        if (bt.fReferenceDocId.getValue() != 888L) {
            System.err.println("tmp.fReferenceDocId.getValue() " + bt.fReferenceDocId.getValue());
            return true;
        }

        if (!bt.fReferenceDocName.getValue().equals("Phone bill")) {
            System.err.println("tmp.fReferenceDocName.getValue() " + bt.fReferenceDocName.getValue());
            return false;
        }

        if (bt.fReferenceDocType.getValue() != ReferenceDocEnum.BankTransaction) {
            System.err.println("tmp.fReferenceDocType.getValue() " + bt.fReferenceDocType.getValue());
            return false;
        }


        OwnedListField<AccountingLeg> legs = bt.getAccountingLegs();
        if (legs.size() != 2) {
            System.err.println("tmp.getAccountingLegs().size() " + legs.size());
            return false;
        }

        if (wrongLeg(legs.get(0), "BANK", "My bank", amount, AccountingEntrySide.debit)) {
            return false;
        }
        if (wrongLeg(legs.get(1), "UTILITIES", "Telephone", amount, AccountingEntrySide.credit)) {
            return false;
        }

        return true;
    }

    private BusinessTransaction correctClientPayment() {
        return argThat(new ArgumentMatcher<BusinessTransaction>() {
            @Override
            public boolean matches(Object o) {
                return isClientPaymentOk((BusinessTransaction) o);
            }
        });
    }

    private boolean isClientPaymentOk(BusinessTransaction bt) {
        if (!bt.fName.getValue().equals("2010/1")
                || !bt.fBusinessAccountUri.getValue().equals("ba1")
                || !bt.fDescription.getValue().equals("Payment received from client :Jim Walls & Co")) {
            System.err.println("bt.fName.getValue() " + bt.fName.getValue());
            System.err.println("bt.fDescription.getValue() " + bt.fDescription.getValue());

            return false;
        }

        if (bt.fBusinessTransaction.getValue() != BusinessTransactionEnum.ClientPayment) {
            System.err.println("bt.fBusinessTransaction.getValue() " + bt.fBusinessTransaction.getValue());
            return false;
        }


        if (bt.fReferenceDocId.getValue() != 42L) {
            System.err.println("bt.fReferenceDocId.getValue() " + bt.fReferenceDocId.getValue());
            return false;
        }

        if (!bt.fReferenceDocName.getValue().equals("2010/1")) {
            System.err.println("bt.fReferenceDocName.getValue() " + bt.fReferenceDocName.getValue());
            return false;
        }

        if (bt.fReferenceDocType.getValue() != ReferenceDocEnum.Invoice) {
            System.err.println("bt.fReferenceDocType.getValue() " + bt.fReferenceDocType.getValue());
            return false;
        }

        OwnedListField<AccountingLeg> legs = bt.getAccountingLegs();
        if (legs.size() != 2) {
            System.err.println("bt.getAccountingLegs().size() " + legs.size());
            return false;
        }

        if (wrongLeg(legs.get(0), "BANK", "BANK", 105750.0, AccountingEntrySide.debit)) {
            return false;
        }
        if (wrongLeg(legs.get(1), "ACCOUNTS_RECEIVABLE", "Jim Walls & Co", 105750.0, AccountingEntrySide.credit)) {
            return false;
        }
        return true;
    }


    @Test
    public void testDeleteInvoiceRelatedEntries() throws Exception {
        Invoice inv = PojoTestUtils.createInvoiceVAT();

        dep.deleteInvoiceRelatedEntries(inv);

        verify(dep.businessTransactionDao, times(1)).findByDocRelation("ba1", 42L, ReferenceDocEnum.Invoice);
        verify(dep.businessTransactionDao, times(2)).delete(anyLong());
    }

    @Test
    public void testDeleteExpenseRelatedEntries() throws Exception {
        Invoice exp = PojoTestUtils.createExpense();
        exp.setId(21L);

        dep.deleteExpenseRelatedEntries(exp);

        verify(dep.businessTransactionDao, times(1)).findByDocRelation("ba1", 21L, ReferenceDocEnum.Expense);
        verify(dep.businessTransactionDao, times(2)).delete(anyLong());
    }

    @Test
    public void testDeleteBankTransRelatedEntries() throws Exception {
        BankTransaction bt = PojoTestUtils.createBankTransaction();

        dep.deleteBankTransRelatedEntries(bt);

        verify(dep.businessTransactionDao, times(1)).findByDocRelation("ba1", 111L, ReferenceDocEnum.BankTransaction);
        verify(dep.businessTransactionDao, times(2)).delete(anyLong());
    }


}

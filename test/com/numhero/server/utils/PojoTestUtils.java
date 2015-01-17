package com.numhero.server.utils;

import com.numhero.client.model.pojoc.*;
import com.numhero.server.service.CompanyBuilder;
import com.numhero.shared.enums.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PojoTestUtils {

    public static Date date = new Date();
    public static Date dueDate = new Date();
    public static Date raisedDate = new Date();
    public static final String BA_URI = "ba1";

    public static User createUser() {
        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");
        user.setLastLogin(date);
        user.fBusinessAccountUri.setValue(BA_URI);
        user.addRelationToBa(BA_URI, UserRoleEnum.free);
        return user;
    }


    public static Invoice createExpense() {
        Invoice expense = new Invoice();
        //expense.setId(21L);
        expense.setDateDue(dueDate);
        expense.setDateRaised(raisedDate);
        expense.setInvoiceType(InvoiceTypeEnum.Expense);
        expense.setInvoiceStatus(InvoiceStatusEnum.Draft);
        expense.setDiscount(0.0);
        expense.fName.setValue("111");
        expense.fClientSupplierID.setValue(22L);
        expense.setTermsConditions("shipment will be done in 2 days from confirmation of payment");
        expense.setNotes("payable by bank transfer");

        expense.fBusinessAccountUri.setValue(BA_URI);
        expense.fAccountID.setValue(2L);
        expense.fAccountName.setValue(CompanyBuilder.CAT_OFFICE_SUPPLIES);

        expense.fValue.setValue(7050.0);
        expense.setCurrency(CurrencyEnum.EUR);
        InvoiceDetail id1 = createInvoiceDetail();
        id1.setPrice(100.0);
        InvoiceDetail id2 = createInvoiceDetail();
        id2.setPrice(200.0);
        expense.addInvoiceDetail(id1);
        expense.addInvoiceDetail(id2);
        return expense;
    }

    public static Invoice createNewInvoice() {
        Invoice inv = createInvoice();
        inv.setId(null);
        return inv;
    }

    public static Invoice createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(42L);
        invoice.setDateDue(dueDate);
        invoice.setDateRaised(raisedDate);
        invoice.setInvoiceType(InvoiceTypeEnum.Invoice);
        invoice.setInvoiceStatus(InvoiceStatusEnum.Draft);
        invoice.setDiscount(0.0);
        invoice.fName.setValue("2010/1");
        invoice.fClientSupplierID.setValue(21L);
        invoice.setTermsConditions("shipment will be done in 2 days from confirmation of payment");
        invoice.setNotes("payable by bank transfer");
        invoice.fBusinessAccountUri.setValue(BA_URI);
        invoice.fValue.setValue(70500.0);
        invoice.setCurrency(CurrencyEnum.USD);
        InvoiceDetail id1 = createInvoiceDetail();
        id1.setPrice(1000.0);
        InvoiceDetail id2 = createInvoiceDetail();
        id2.setPrice(2000.0);
        invoice.addInvoiceDetail(id1);
        invoice.addInvoiceDetail(id2);
        return invoice;
    }

    public static Invoice createEstimate() {
        Invoice estimate = new Invoice();
        estimate.setDateDue(dueDate);
        estimate.setDateRaised(raisedDate);
        estimate.setInvoiceType(InvoiceTypeEnum.Estimate);
        estimate.setAccountID(0L);
        estimate.setAccountName("fake");
        estimate.setDiscount(10.0);
        estimate.setTermsConditions("shipment will be done in 2 days from confirmation of payment");
        estimate.setNotes("payable by bank transfer");
        estimate.fBusinessAccountUri.setValue(BA_URI);
        estimate.setCurrency(CurrencyEnum.USD);
        estimate.fClientSupplierID.setValue(12L);
        InvoiceDetail id1 = createInvoiceDetail(1000.0, 2.0, "detail1", false);
        InvoiceDetail id2 = createInvoiceDetail(1000.0, 2.0, "detail1", false);
        estimate.addInvoiceDetail(id1);
        estimate.addInvoiceDetail(id2);
        estimate.setPrice(1427.625d);
        return estimate;
    }

    public static InvoiceDetail createInvoiceDetail() {
        InvoiceDetail detail = new InvoiceDetail();
        detail.setPrice(100.0);
        detail.fName.setValue("detail");
        detail.fDescription.setValue("product # ...");
        detail.fProductID.setValue(1L);
        detail.setQuantity(20.0);
        detail.fTax1ID.setValue(1L);
        return detail;
    }

    public static TaxInfo createPercentTaxInfo() {
        TaxInfo tax1 = new TaxInfo();
        tax1.fId.setValue(1L);
        tax1.fName.setValue("VAT175");
        tax1.fPercent.setValue(17.5);
        tax1.fIsVAT.setValue(true);
        tax1.fBusinessAccountUri.setValue(BA_URI);
        return tax1;
    }


    public static BankAccount createBankAccount() {
        BankAccount account = new BankAccount();
        account.fName.setValue("My bank");
        account.setDescription("my bank description");
        account.fBusinessAccountUri.setValue(BA_URI);
        return account;
    }


    public static ProductService createProduct() {
        ProductService productService = new ProductService();
        productService.fBusinessAccountUri.setValue(BA_URI);
        productService.setDescription("description");
        productService.fName.setValue("productService 1");
        productService.setUnitPrice(20.0);
        return productService;
    }

    public static ProductService createService() {
        ProductService service = new ProductService();
        service.fBusinessAccountUri.setValue("compId");
        service.setDescription("description");
        service.fName.setValue("productService 1");
        service.setUnitPrice(20.0);
        service.setServiceUnit(ServiceUnitEnum.Day);
        service.fBusinessAccountUri.setValue("123");
        return service;
    }

    public static BankTransaction createBankTransaction() {
        BankTransaction businessTransaction = new BankTransaction();
        businessTransaction.setId(111L);
        businessTransaction.setAccountID(1L);
        businessTransaction.setAccountName("Telephone");
        businessTransaction.fName.setValue("Phone bill");
        businessTransaction.fBankAccountId.setValue(100L);
        businessTransaction.fBankAccountName.setValue("my bank");
        businessTransaction.fBusinessAccountUri.setValue(BA_URI);
        businessTransaction.fCurrency.setValue(CurrencyEnum.EUR);
        businessTransaction.fValue.setValue(2345.0);
        return businessTransaction;
    }

    public static ExpenseReceipt createExpenseReceipt() {
        ExpenseReceipt expenseReceipt = new ExpenseReceipt();
        expenseReceipt.fBusinessAccountUri.setValue(BA_URI);
        expenseReceipt.fReceiptStatus.setValue(ReceiptStatusEnum.Presented);
        expenseReceipt.fValue.setValue(1000.0);
        return expenseReceipt;
    }

    public static Map<Long, TaxInfo> createTaxesMap() {
        Map<Long, TaxInfo> ret = new HashMap<Long, TaxInfo>();
        TaxInfo tax = new TaxInfo();
        tax.setId(1L);
        tax.fIsVAT.setValue(true);
        tax.fName.setValue("VAT");
        tax.setPercent(17.5d);
        ret.put(1L, tax);
        return ret;
    }


    public static BusinessAccount createBusinessAccount() {
        BusinessAccount account = new BusinessAccount();
        account.setId(123L);
        account.fCurrency.setValue(CurrencyEnum.EUR);
        account.fDateFormat.setValue(DateFormatEnum.ddmmyyyycolon);
        account.fName.setValue("NetNumero LLC");
        account.fBusinessAccountUri.setValue(BA_URI);
        account.fDescription.setValue("NetNumero Business Accounting");
        account.fDefaultDaysDue.setValue(30L);
        account.fEmail.setValue("me@b.com");
        account.fPhone.setValue("+49178834523");
        account.fPaymentMethod.setValue(PaymentMethodEnum.BANK_PAYMENT);
        account.fTermsConditions.setValue("my terms for products");
        account.fTimeFormat.setValue(TimeFormatEnum.hhmmssscolon);
        account.fVat.setValue("DE3454563456");
        account.fAddress.setValue("Immermanstrasse 210");
        account.fCity.setValue("Dusseldorf");
        account.fRegion.setValue("NRW");
        account.fCountry.setValue(CountryEnum.DE);
        account.fZipCode.setValue("40470");
        account.fPrefix.setValue("2010/");
        account.fWeb.setValue("www.netnumero.com");

        try {
            InputStream is = PojoTestUtils.class.getResourceAsStream("bg-logo.gif");
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[] logo = buffer.toByteArray();

            account.fCompanyLogo.setValue(logo);
            account.fCompanyLogoThumb.setValue(logo);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return account;
    }

    public static ClientSupplier createClientSupplier() {
        ClientSupplier clientSupplier = new ClientSupplier();
        clientSupplier.fId.setValue(21L);
        clientSupplier.fBusinessAccountUri.setValue(BA_URI);
        clientSupplier.fName.setValue("Jim Walls & Co");
        clientSupplier.fVat.setValue("DE1234567");
        clientSupplier.fCompanyEmail.setValue("client@jimwalls.de");
        clientSupplier.fCompanyFax.setValue("+4909120909");
        clientSupplier.fCompanyPhone.setValue("+49129128093812");
        clientSupplier.fAddress.setValue("kaiserswertherstr 115");
        clientSupplier.fCity.setValue("Dusseldorf");
        clientSupplier.fRegion.setValue("NRW");
        clientSupplier.fCountry.setValue(CountryEnum.DE);
        clientSupplier.fZipCode.setValue("40474");
        clientSupplier.fClient.setValue(true);
        clientSupplier.fSupplier.setValue(true);
        clientSupplier.fNotes.setValue("bank is Sparkasse 67 - Dusseldorf");
        return clientSupplier;
    }

    public static AccountingLeg createAccountingLeg(BusinessTransaction entry) {
        AccountingLeg leg = new AccountingLeg();
//        leg.fAccountingEntryID.setValue(entry.getId());
//        leg.fAccountingEntryName.setValue(entry.getName());
        leg.fBusinessAccountUri.setValue(entry.fBusinessAccountUri.getValue());
        return leg;
    }

    public static BusinessTransaction createAccountingEntry() {
        BusinessTransaction entry = new BusinessTransaction();
        entry.fBusinessAccountUri.setValue(BA_URI);
        entry.fDate.setValue(new Date());
        entry.fBusinessTransaction.setValue(BusinessTransactionEnum.ClientPayment);
        entry.fReferenceDocId.setValue(42L);
        entry.fReferenceDocName.setValue("Bank trans");
        entry.fReferenceDocType.setValue(ReferenceDocEnum.BankTransaction);


        AccountingLeg leg1 = new AccountingLeg();
        leg1.fAccountId.setValue(1L);
        leg1.fNominalCode.setValue(CompanyBuilder.ACCOUNTS_RECEIVABLE);

        leg1.fDoubleEntryType.setValue(AccountingEntrySide.credit);
        leg1.fValue.setValue(1000.0);


        AccountingLeg leg2 = new AccountingLeg();
        leg2.fAccountId.setValue(2L);
        leg2.fNominalCode.setValue(CompanyBuilder.SALES);
        leg2.fDoubleEntryType.setValue(AccountingEntrySide.debit);
        leg2.fValue.setValue(1000.0);

        entry.addAccountingLeg(leg1);
        entry.addAccountingLeg(leg2);
        return entry;
    }

    public static NominalLedgerAccount createNominalLedgerAccount() {
        NominalLedgerAccount la = new NominalLedgerAccount();
        la.fAccountingGroup.setValue(AccountingGroupEnum.Expense);
        la.fBalanceSheetType.setValue(BalanceSheetEnum.isSales);
        la.fBusinessAccountUri.setValue(BA_URI);
        la.fDescription.setValue("descr");
        la.fName.setValue("name");
        la.fCode.setValue("a/c");

        return la;
    }

    public static Invoice createInvoiceNoVat() {
        Invoice invoice = createInvoice();
        invoice.getDetails().clear();
        invoice.fValue.setValue(2000.0);
        invoice.setCurrency(CurrencyEnum.EUR);
        invoice.addInvoiceDetail(createInvoiceDetail(100.0, 10.0, "detail1", false));
        invoice.addInvoiceDetail(createInvoiceDetail(1000.0, 1.0, "detail2", false));
        return invoice;

    }

    private static InvoiceDetail createInvoiceDetail(double price, double quantity, String name, boolean vat) {
        InvoiceDetail id1 = new InvoiceDetail();
        id1.setPrice(price);
        id1.setQuantity(quantity);
        id1.fName.setValue(name);
        if (vat) {
            id1.fTax1ID.setValue(1L);
        }
        return id1;
    }


    public static Invoice createInvoiceVAT() {
        Invoice invoice = createInvoice();
        invoice.getDetails().clear();
        invoice.fValue.setValue(2500.0); //20% vat
        invoice.setCurrency(CurrencyEnum.EUR);
        invoice.addInvoiceDetail(createInvoiceDetail(100.0, 10.0, "detail1", true));
        invoice.addInvoiceDetail(createInvoiceDetail(1000.0, 1.0, "detail2", true));
        return invoice;
    }

    public static Invoice createInvoiceUSD() {
        Invoice invoice = createInvoiceVAT();
        invoice.setCurrency(CurrencyEnum.USD);
        return invoice;
    }

    public static Invoice createInvoiceMultiVAT() {
        Invoice invoice = createInvoice();
        invoice.getDetails().clear();
        invoice.fValue.setValue(2500.0); //20% vat
        invoice.setCurrency(CurrencyEnum.EUR);
        invoice.addInvoiceDetail(createInvoiceDetail(100.0, 10.0, "detail1", 11L, 12L));
        invoice.addInvoiceDetail(createInvoiceDetail(400.0, 2.0, "detail2", 12L, 13L));
        invoice.addInvoiceDetail(createInvoiceDetail(200.0, 3.0, "detail3", null, 14L));
        return invoice;


    }

    private static InvoiceDetail createInvoiceDetail(double price, double quantity, String name, Long tax1Id, Long tax2Id) {
        InvoiceDetail id1 = new InvoiceDetail();
        id1.setPrice(price);
        id1.setQuantity(quantity);
        id1.fName.setValue(name);
        id1.fTax1ID.setValue(tax1Id);
        id1.fTax2ID.setValue(tax2Id);
        return id1;
    }

    public static TaxInfo createVatTaxInfo(double percent) {
        TaxInfo tax = new TaxInfo();
        tax.fIsVAT.setValue(true);
        tax.fPercent.setValue(percent);
        tax.fName.setValue("VAT" + percent);
        return tax;
    }

    public static Category createCategory() {
        Category cat = new Category();
        cat.setId(1L);
        cat.fBusinessAccountUri.setValue(BA_URI);
        cat.fName.setValue("Telephone");
        return cat;
    }

    public static Category createCategoryTaxi() {
        Category cat = new Category();
        cat.fName.setValue("Taxi");
        return cat;
    }

    public static Map<Category, Double> createReceipts() {
        HashMap<Category, Double> map = new HashMap<Category, Double>();
        map.put(createCategory(), 2000.0);
        map.put(createCategoryTaxi(), 345.0);
        return map;
    }

    public static ClientSupplier createSupplier() {
        ClientSupplier clientSupplier = new ClientSupplier();
        clientSupplier.fId.setValue(22L);
        clientSupplier.fBusinessAccountUri.setValue(BA_URI);
        clientSupplier.fName.setValue("Bauhaus");
        clientSupplier.fCompanyEmail.setValue("client@bauhaus.de");
        clientSupplier.fCompanyFax.setValue("+4909120909");
        clientSupplier.fCompanyPhone.setValue("+49129128093812");
        clientSupplier.fAddress.setValue("kaiserswertherstr 115");
        clientSupplier.fCity.setValue("Dusseldorf");
        clientSupplier.fRegion.setValue("NRW");
        clientSupplier.fCountry.setValue(CountryEnum.DE);
        clientSupplier.fZipCode.setValue("40474");
        clientSupplier.fClient.setValue(false);
        clientSupplier.fSupplier.setValue(true);
        clientSupplier.fNotes.setValue("bank is Sparkasse 67 - Dusseldorf");

        return clientSupplier;
    }


    public static Project createProject() {
        Project project = new Project();
        project.setDescription("a time entry");
        project.fBusinessAccountUri.setValue(BA_URI);
        return project;
    }

    public static ProjectTaskDetail createProjectTaskDetail() {
        ProjectTaskDetail task = new ProjectTaskDetail();
        task.setDescription("a certain task");
        return task;
    }


    public static Task createTask() {
        Task task = new Task();
        task.setDescription("a certain task");
        task.fBusinessAccountUri.setValue(BA_URI);
        return task;
    }

    public static Staff createStaff() {
        Staff staff = new Staff();
        staff.fName.setValue("Pamela");
        staff.setId(123L);
        return staff;
    }


}

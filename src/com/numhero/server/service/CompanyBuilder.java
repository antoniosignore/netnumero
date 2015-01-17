package com.numhero.server.service;

import com.google.inject.Inject;
import com.numhero.client.model.pojoc.*;
import com.numhero.server.model.daolite.*;
import com.numhero.server.utils.LocalesUtils;
import com.numhero.shared.enums.*;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class CompanyBuilder {

    private static final Logger log = Logger.getLogger(CompanyBuilder.class.getName());

    @Inject
    public CategoryDao categoryDao;

    @Inject
    public TaskDao taskDao;

    @Inject
    public NominalLedgerAccountDao nominalLedgerAccountDao;

    @Inject
    public BusinessAccountDao baDao;

    @Inject
    public StaffDao staffDao;

    @Inject
    public TaxInfoDao taxDao;

    @Inject
    public BankAccountDao bankAccountDao;

    ResourceBundle bundle;
    public static final String ACCOUNTS_PAYABLE = "ACCOUNTS_PAYABLE";
    public static final String ACCOUNTS_RECEIVABLE = "ACCOUNTS_RECEIVABLE";
    public static final String BANK = "BANK";
    public static final String BANK_CHARGES = "BANK_CHARGES";
    public static final String VAT = "VAT";
    public static final String TAXES = "TAXES";
    public static final String CUSTOM_DUTIES = "CUSTOM_DUTIES";
    public static final String TRANSPORTS = "TRANSPORTS";
    public static final String BAD_DEBTS = "BAD_DEBTS";
    public static final String SALES = "SALES";
    public static final String INVENTORY = "INVENTORY";
    public static final String PURCHASES = "PURCHASES";
    public static final String CAT_UTILITIES = "UTILITIES";
    public static final String UTILITIES = CAT_UTILITIES;
    public static final String WAGES = "WAGES";
    public static final String NON_BILLABLE_EXPENSES = "NON_BILLABLE_EXPENSES";
    public static final String BILLABLE_EXPENSES = "BILLABLE_EXPENSES";
    public static final String MISCELLANEOUS_EXPENSES = "MISCELLANEOUS_EXPENSES";
    public static final String CURRENCY_FX_GAIN = "CURRENCY_FX_GAIN";
    public static final String CURRENCY_FX_LOSS = "CURRENCY_FX_LOSS";
    public static final String CASH = "CASH";
    public static final String DEPRECIATION = "DEPRECIATION";
    public static final String CAPITAL = "CAPITAL";
    public static final String INSURANCE = "INSURANCE";
    public static final String DISCOUNTS = "DISCOUNTS";
    public static final String RETURNS = "RETURNS";
    public static final String CAT_CAR = "CAR";
    public static final String CAT_ADVERTISING = "ADVERTISING";
    public static final String CAT_MAINTENANCE = "MAINTENANCE";
    public static final String CAT_MEALS_ENTERTAINMENT = "MEALS_ENTERTAINMENT";
    public static final String CAT_MILAGE = "MILAGE";
    public static final String CAT_INTEREST = "INTEREST";
    public static final String CAT_OFFICE_SUPPLIES = "OFFICE_SUPPLIES";
    public static final String CAT_RENT = "RENT";
    public static final String CAT_TRAVEL = "TRAVEL";
    public static final String CAT_OTHER = "OTHER";


    public static final String MAILSERVER_NETNUMERO_COM = "mailserver@netnumero.com";
    public static final String ADMIN_NETNUMERO_COM = "admin@netnumero.com";

    public void addAccounts(String baName, CountryEnum countryCode) {

        bundle = LocalesUtils.getBundle(countryCode);

        createNominalLedgerAccount(baName, ACCOUNTS_PAYABLE, AccountingGroupEnum.Liability, bundle.getString("payableDesc"));
        createNominalLedgerAccount(baName, ACCOUNTS_RECEIVABLE, AccountingGroupEnum.Asset, bundle.getString("receivableDesc"));
        createNominalLedgerAccount(baName, BANK, AccountingGroupEnum.Liability, bundle.getString("bankDesc"));
        createNominalLedgerAccount(baName, BANK_CHARGES, AccountingGroupEnum.Expense, bundle.getString("bankChargesDesc"));
        createNominalLedgerAccount(baName, VAT, AccountingGroupEnum.Asset, bundle.getString("vatSalesDesc"));
        createNominalLedgerAccount(baName, TAXES, AccountingGroupEnum.Asset, bundle.getString("taxesSalesDesc"));
        createNominalLedgerAccount(baName, CUSTOM_DUTIES, AccountingGroupEnum.Expense, bundle.getString("customDesc"), BalanceSheetEnum.isCostOfSales);
        createNominalLedgerAccount(baName, TRANSPORTS, AccountingGroupEnum.Expense, bundle.getString("transportsDesc"), BalanceSheetEnum.isCostOfSales);
        createNominalLedgerAccount(baName, BAD_DEBTS, AccountingGroupEnum.Expense, bundle.getString("badDebtsDesc"));
        createNominalLedgerAccount(baName, SALES, AccountingGroupEnum.Income, bundle.getString("salesDesc"), BalanceSheetEnum.isSales);
        createNominalLedgerAccount(baName, INVENTORY, AccountingGroupEnum.Asset, bundle.getString("vatSalesDesc"));
        createNominalLedgerAccount(baName, PURCHASES, AccountingGroupEnum.Expense, bundle.getString("purchasesDesc"), BalanceSheetEnum.isCostOfSales);
        createNominalLedgerAccount(baName, UTILITIES, AccountingGroupEnum.Expense, bundle.getString("utilitiesExpDesc"));
        createNominalLedgerAccount(baName, WAGES, AccountingGroupEnum.Expense, bundle.getString("wagesDesc"));
        createNominalLedgerAccount(baName, NON_BILLABLE_EXPENSES, AccountingGroupEnum.Expense, bundle.getString("notBillableExpensesDesc"));
        createNominalLedgerAccount(baName, BILLABLE_EXPENSES, AccountingGroupEnum.Expense, bundle.getString("billableExpenses"));
        createNominalLedgerAccount(baName, MISCELLANEOUS_EXPENSES, AccountingGroupEnum.Expense, bundle.getString("otherCostsDesc"));
        createNominalLedgerAccount(baName, CURRENCY_FX_GAIN, AccountingGroupEnum.Expense, bundle.getString("currencyGains"));
        createNominalLedgerAccount(baName, CURRENCY_FX_LOSS, AccountingGroupEnum.Expense, bundle.getString("currencyLoss"));
        createNominalLedgerAccount(baName, CASH, AccountingGroupEnum.Asset, bundle.getString("cash"));
        createNominalLedgerAccount(baName, DEPRECIATION, AccountingGroupEnum.Expense, bundle.getString("depreciationDesc"));
        createNominalLedgerAccount(baName, CAPITAL, AccountingGroupEnum.Capital, bundle.getString("aBusinessByItsOwners"));
        createNominalLedgerAccount(baName, INSURANCE, AccountingGroupEnum.Expense, bundle.getString("insuranceDesc"));
        createNominalLedgerAccount(baName, DISCOUNTS, AccountingGroupEnum.Expense, bundle.getString("discountsDesc"));
        createNominalLedgerAccount(baName, RETURNS, AccountingGroupEnum.Expense, bundle.getString("clientReturnsDesc"));

        createCategory(baName, bundle.getString(CAT_CAR));
        createCategory(baName, bundle.getString(CAT_ADVERTISING));
        createCategory(baName, bundle.getString(CAT_MAINTENANCE));
        createCategory(baName, bundle.getString(CAT_MEALS_ENTERTAINMENT));
        createCategory(baName, bundle.getString(CAT_MILAGE));
        createCategory(baName, bundle.getString(CAT_INTEREST));
        createCategory(baName, bundle.getString(CAT_OFFICE_SUPPLIES));
        createCategory(baName, bundle.getString(CAT_RENT));
        createCategory(baName, bundle.getString(CAT_TRAVEL));
        createCategory(baName, bundle.getString(CAT_UTILITIES));
        createCategory(baName, bundle.getString(CAT_OTHER));
    }

    public BusinessAccount build(String baName, String countryCode, User user) {
        BusinessAccount ba;
        ba = new BusinessAccount();
        ba.fName.setValue(baName);
        ba.fBusinessAccountUri.setValue(baName);
        ba.fCountry.setValue(CountryEnum.valueOf(countryCode));
        ba.fEmail.setValue(user.fEmail.getValue());

        bundle = LocalesUtils.getBundle(CountryEnum.valueOf(countryCode));
        ba.fPrefix.setValue("InvoiceId");

        ba.fCurrency.setValue(CountryEnum.getCurrByCountryCode(countryCode));

        baDao.save(ba);

        addAccounts(baName, ba.fCountry.getValue());
        createMainTradingBankAccount(baName, ba);
        addDefaultTasks(ba, ba.fCountry.getValue());
        addTaxes(baName, ba.fCountry.getValue(), ba.fCurrency.getValue());
        createNewStaffAdminIfNotExist(baName, user, ba, ba.fCountry.getValue());
        return ba;
    }

    private void createMainTradingBankAccount(String baName, BusinessAccount ba) {
        BankAccount account = new BankAccount();
        account.fCurrency.setValue(ba.fCurrency.getValue());
        bundle = LocalesUtils.getBundle(ba.fCountry.getValue());
        account.fIsMainTradingAccount.setValue(true);
        account.fName.setValue(ba.fName.getValue());
        account.setDescription(bundle.getString("main.trading.account"));
        account.fBusinessAccountUri.setValue(baName);
        bankAccountDao.save(account);
    }

    private void addTaxes(String baName, CountryEnum countryCode, CurrencyEnum curr) {
        //data from here:  http://en.wikipedia.org/wiki/Value_added_tax

        bundle = LocalesUtils.getBundle(countryCode);

        switch (countryCode) {
            case DE:
                createTax(baName, bundle.getString("mw0"), 0, curr);
                createTax(baName, bundle.getString("mw7"), 7, curr);
                createTax(baName, bundle.getString("mw19"), 19, curr);
                break;
            case GB:
                createTax(baName, bundle.getString("vat0"), 0, curr);
                createTax(baName, bundle.getString("vat5"), 5, curr);
                createTax(baName, bundle.getString("vat17.5"), 17.5, curr);
                break;
            case IT:
                createTax(baName, bundle.getString("iva0"), 0, curr);
                createTax(baName, bundle.getString("iva4"), 4, curr);
                createTax(baName, bundle.getString("iva10"), 10, curr);
                createTax(baName, bundle.getString("iva20"), 20, curr);
                break;
        }
    }

    private void createTax(String baName, String name, double percent, CurrencyEnum curr) {
        TaxInfo t = new TaxInfo();
        t.fBusinessAccountUri.setValue(baName);
        t.fName.setValue(name);
        t.fDescription.setValue(name);
        t.fIsVAT.setValue(true);
        t.fPercent.setValue(percent);
        t.fCurrency.setValue(curr);
        taxDao.save(t);
    }

    public void addDefaultTasks(BusinessAccount ba,
                                CountryEnum countryCode) {

        bundle = LocalesUtils.getBundle(countryCode);

        createTask(ba, bundle.getString("Meetings"));
        createTask(ba, bundle.getString("Research"));
        createTask(ba, bundle.getString("Management"));
        createTask(ba, bundle.getString("Development"));
        createTask(ba, bundle.getString("Test"));
        createTask(ba, bundle.getString(CAT_OTHER));
    }

    public void createCategory(String baName, String catName) {
        Category cat1 = new Category();
        cat1.fBusinessAccountUri.setValue(baName);
        cat1.fName.setValue(catName);
        categoryDao.save(cat1);
    }

    private void createNominalLedgerAccount(String baName, String code, AccountingGroupEnum group, String desc, BalanceSheetEnum balanceSheet) {
        createNominalLedgerAccount(baName, bundle.getString(code), group, code, desc, balanceSheet);

    }


    public void createNominalLedgerAccount(String baName,
                                           String code,
                                           AccountingGroupEnum group,
                                           String desc) {
        createNominalLedgerAccount(baName, bundle.getString(code), group, code, desc, BalanceSheetEnum.unused);
    }


    public void createNominalLedgerAccount(String baName,
                                           String catName,
                                           AccountingGroupEnum group,
                                           String code,
                                           String desc,
                                           BalanceSheetEnum type) {
        NominalLedgerAccount account = new NominalLedgerAccount();
        account.fBusinessAccountUri.setValue(baName);
        account.fDescription.setValue(desc);
        account.fName.setValue(catName);
        account.fAccountingGroup.setValue(group);
        account.fBalanceSheetType.setValue(type);
        account.fCode.setValue(code);
        nominalLedgerAccountDao.save(account);
    }

    public void createTask(BusinessAccount ba, String taskName) {
        Task task = new Task();
        task.fBusinessAccountUri.setValue(ba.fName.getValue());
        task.fName.setValue(taskName);
        task.fCurrency.setValue(ba.fCurrency.getValue());
        taskDao.save(task);
    }

    private void createNewStaffAdminIfNotExist(String baName,
                                               User user,
                                               BusinessAccount ba,
                                               CountryEnum countryCode) {
        Staff admin = staffDao.findByUserId(baName, user.getId());
        bundle = LocalesUtils.getBundle(countryCode);

        if (admin == null) {
            Staff staff = new Staff();

            staff.fName.setValue(bundle.getString("admin"));

            staff.fUserId.setValue(user.getId());
            staff.fEmail.setValue(user.fEmail.getValue());
            staff.setStaffType(StaffTypeEnum.Internal);
            staff.fBusinessAccountUri.setValue(baName);
            staff.fCurrency.setValue(ba.fCurrency.getValue());

            staff.fAddress.setValue(ba.fAddress.getValue());
            staff.fCity.setValue(ba.fCity.getValue());
            staff.fCountry.setValue(ba.fCountry.getValue());
            staff.fRegion.setValue(ba.fRegion.getValue());
            staff.fFax.setValue(ba.fFax.getValue());
            staff.fPhone.setValue(ba.fPhone.getValue());
            staff.fZipCode.setValue(ba.fZipCode.getValue());

            staffDao.save(staff);
        }
    }
}

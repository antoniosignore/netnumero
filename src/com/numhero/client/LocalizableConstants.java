package com.numhero.client;

import com.google.gwt.i18n.client.Constants;
import com.numhero.client.mvp.bankaccount.BankAccountConstants;
import com.numhero.client.mvp.banktransaction.BankTransConstants;
import com.numhero.client.mvp.category.CategoryConstants;
import com.numhero.client.mvp.clientsupplier.ClientsConstants;
import com.numhero.client.mvp.document.InvoiceConstants;
import com.numhero.client.mvp.expense.ExpenseReceiptConstants;
import com.numhero.client.mvp.product.ProductConstants;
import com.numhero.client.mvp.project.ProjectConstants;
import com.numhero.client.mvp.service.ServiceConstants;
import com.numhero.client.mvp.staff.StaffConstants;
import com.numhero.client.mvp.task.TaskConstants;
import com.numhero.client.mvp.taxinfo.TaxInfoConstants;
import com.numhero.client.mvp.timeentry.TimeEntryConstants;

import java.util.Map;

public interface LocalizableConstants extends Constants, ClientsConstants, InvoiceConstants, TaskConstants, BankAccountConstants,BankTransConstants, CategoryConstants, ProductConstants, ServiceConstants, StaffConstants, TaxInfoConstants, TimeEntryConstants, ProjectConstants, ExpenseReceiptConstants {

    // general messages --------------------------------------------------------
    @DefaultStringValue("New")
    String newAction();

    @DefaultStringValue("Create")
    String createAction();

    @DefaultStringValue("Edit")
    String editAction();

    @DefaultStringValue("Welcome")
    String welcome();

    @DefaultStringValue("Name")
    String name();

    @DefaultStringValue("Description")
    String description();

    @DefaultStringValue("Type")
    String type();

    @DefaultStringValue("Web")
    String web();

    @DefaultStringValue("Most recent")
    String mostRecent();

    @DefaultStringArrayValue({"Invoice", "Estimate", "Expense"})
    String[] invoiceType();

    @DefaultStringArrayValue({"Product", "Service"})
    String[] productType();


    // validation --------------------------------------------------------
    @DefaultStringMapValue({
            "required", "is required",
            "isNotAnEmail", "must contain a valid email",
            "isNotAPhone", "must contain a valid phone number",
            "url", "must contain a valid URL",
            "invalidCharacters", "contains invalid characters"
    })
    Map<String, String> validationMessages();

    @DefaultStringMapValue({
            "clientSupplierExists", "A client or a supplier with this name / vat already exists.",
            "productServiceExists", "A product or a service with this name already exists.",
            "staffExists", "A staff or contractor with this name already exists.",
            "taxInfoExists", "A tax with this name already exists.",
            "sendMailClientEmailMissing", "You must define the email of the client specified in the invoice.",
            "sendMailFailed", "Oops, something went wrong. Please try again later or contact support@netnumero.com",
            "noEmailAddressForBA", "Please specify a valid email address for your Business Account",
            "cannotConvertInvoiceCurrencyIntoBaCurrency", "Cannot convert Yahoo currency"
    })
    Map<String, String> errorMessages();

    @DefaultStringValue("Error, impossible to perform the operation. Please recheck your data.")
        //this means we need a specific error but it's a normal message to user
    String generalUntranslatedErrorMessage();

    @DefaultStringValue("Oops! An error occurred on the server. Please retry later or contact support@netnumero.com")
        //this means an unexpected exception occurred
    String generalUnexpectedErrorMessage();


    // combo box --------------------------------------------------------
    @DefaultStringValue("New")
    String addNew();

    @DefaultStringValue("More")
    String more();


    // money in --------------------------------------------------------
    @DefaultStringValue("Invoice Details")
    String invoiceDetails();

    @DefaultStringValue("Invoice")
    String invoice();

    @DefaultStringValue("PDF")
    String pdf();

    @DefaultStringValue("Invoice ID")
    String invoiceID();

    @DefaultStringValue("Estimate Details")
    String estimateDetails();

    @DefaultStringValue("Estimate")
    String estimate();

    @DefaultStringValue("Product")
    String product();

    @DefaultStringValue("Service")
    String service();

    @DefaultStringValue("You must select an existing client / supplier or create one on the fly")
    String selectExistingPartner();

    @DefaultStringValue("Be careful at the prices - you selected a product / service that has it's price in another currency then the invoice.")
    String pricesInDifferentCurrency();

    // money out --------------------------------------------------------
    @DefaultStringValue("Expense Details")
    String expenseDetails();

    @DefaultStringValue("Expense")
    String expense();


    @DefaultStringValue("Client")
    String client();

    @DefaultStringValue("Supplier")
    String supplier();

    @DefaultStringValue("Client is also a Supplier")
    String makeSupplier();

    @DefaultStringValue("Supplier is also a Client")
    String makeClient();

    @DefaultStringValue("This is both a client and a supplier")
    String bothClientAndSupplier();

    @DefaultStringValue("Organisation name")
    String organisationName();

    @DefaultStringValue("Vat")
    String vat();

    @DefaultStringValue("Staff")
    String staff();

    @DefaultStringValue("Created")
    String created();

    @DefaultStringValue("Last Billed")
    String lastBilled();

    @DefaultStringValue("State")
    String state();

    @DefaultStringValue("Hours Not Billed")
    String notBilledHours();

    @DefaultStringValue("Total Hours")
    String totalHours();

    @DefaultStringValue("Client / Supplier")
    String clientSupplier();

    @DefaultStringValue("Date")
    String date();

    @DefaultStringValue("Total")
    String total();

    @DefaultStringValue("Status")
    String status();

    @DefaultStringValue("Bank")
    String bank();

    @DefaultStringValue("Currency")
    String currency();

    @DefaultStringValue("Balance")
    String currentBalance();

    @DefaultStringValue("Company Name")
    String companyName();

    @DefaultStringValue("Contact")
    String contact();

    @DefaultStringValue("Phone")
    String phone();

    @DefaultStringValue("Address")
    String address();

    @DefaultStringValue("Notes")
    String notes();

    @DefaultStringValue("Item")
    String item();

    @DefaultStringValue("Unit Price")
    String unitPrice();

    @DefaultStringValue("Quantity")
    String quantity();

    @DefaultStringValue("Tax 1")
    String tax1();

    @DefaultStringValue("Tax 2")
    String tax2();

    @DefaultStringValue("Tax Percent")
    String taxPercent();

    @DefaultStringValue("Price")
    String price();

    @DefaultStringValue("Project saved")
    String projectSaved();

    @DefaultStringValue("Username")
    String username();

    @DefaultStringValue("Sunday")
    String sunday();

    @DefaultStringValue("Monday")
    String monday();

    @DefaultStringValue("Tuesday")
    String tuesday();

    @DefaultStringValue("Wednesday")
    String wednesday();

    @DefaultStringValue("Thursday")
    String thursday();

    @DefaultStringValue("Friday")
    String friday();

    @DefaultStringValue("Saturday")
    String saturday();

    @DefaultStringValue("January")
    String january();

    @DefaultStringValue("February")
    String february();

    @DefaultStringValue("March")
    String march();

    @DefaultStringValue("April")
    String april();

    @DefaultStringValue("May")
    String may();

    @DefaultStringValue("June")
    String june();

    @DefaultStringValue("July")
    String july();

    @DefaultStringValue("August")
    String august();

    @DefaultStringValue("September")
    String september();

    @DefaultStringValue("October")
    String october();

    @DefaultStringValue("November")
    String november();

    @DefaultStringValue("December")
    String december();

    @DefaultStringValue("New Client")
    String newClient();

    @DefaultStringValue("Edit Client")
    String editClient();

    @DefaultStringValue("New Supplier")
    String newSupplier();

    @DefaultStringValue("Edit Supplier")
    String editSupplier();

    @DefaultStringValue("Invoice saved")
    String invoiceSaved();

    @DefaultStringValue("Client saved successfully")
    String clientSavedSuccessfully();

    @DefaultStringValue("Supplier saved successfully")
    String supplierSavedSuccessfully();

    @DefaultStringValue("Money In")
    String moneyIn();

    @DefaultStringValue("Money Out")
    String moneyOut();

    @DefaultStringValue("Create Invoice")
    String createAnInvoice();

    @DefaultStringValue("This invoice has been completed. You can no longer change it, just view a PDF version of it.")
    String viewInvoice();

    @DefaultStringValue("Expense saved")
    String expenseSaved();

    @DefaultStringValue("Create New Project")
    String createNewProject();

    @DefaultStringValue("Edit Project")
    String editProject();

    @DefaultStringValue("Tasks")
    String tasks();

    @DefaultStringValue("User saved")
    String userSaved();

    @DefaultStringValue("New Contractor")
    String createNewContractor();

    @DefaultStringValue("Edit Contractor")
    String editContractor();

    @DefaultStringValue("Clients")
    String clients();

    @DefaultStringValue("Manage Clients")
    String manageClients();

    @DefaultStringValue("Manage Projects")
    String manageProjects();

    @DefaultStringValue("Create New Time-entry")
    String createNewTimeEntry();

    @DefaultStringValue("Edit Time-entry")
    String editTimeEntry();

    @DefaultStringValue("Users")
    String users();

    @DefaultStringValue("Edit Invoice")
    String editInvoice();

    @DefaultStringValue("Business account saved")
    String businessAccontSaved();

    @DefaultStringValue("Default currencies changed")
    String defaultCurrenciesSaved();

    @DefaultStringValue("Time entry saved")
    String timeEntrySaved();

    @DefaultStringValue("Task saved")
    String taskSaved();

    @DefaultStringValue("Internal staff saved")
    String internalStaffSaved();

    @DefaultStringValue("Contractor saved")
    String contractorSaved();

    @DefaultStringValue("Create New Task")
    String createNewTask();

    @DefaultStringValue("Billable")
    String billable();

    @DefaultStringValue("New Product")
    String newProduct();

    @DefaultStringValue("Edit Product")
    String editProduct();

    @DefaultStringValue("New Service")
    String newService();

    @DefaultStringValue("Edit Service")
    String editService();

    @DefaultStringValue("Service Unit")
    String serviceUnit();

    @DefaultStringValue("Create New User")
    String createNewUser();

    @DefaultStringValue("First Name")
    String firstName();

    @DefaultStringValue("Last Name")
    String lastName();

    @DefaultStringValue("Password")
    String password();

    @DefaultStringValue("User Profile")
    String userProfile();

    @DefaultStringValue("Last Login")
    String lastLogin();

    @DefaultStringValue("Settings")
    String settingsSaved();

    @DefaultStringValue("Edit Settings")
    String editSettings();

    @DefaultStringValue("New Internal/Contractor")
    String newStaff();

    @DefaultStringValue("New Project")
    String newProject();

    @DefaultStringValue("New Contractor")
    String newContractor();

    @DefaultStringValue("New Internal")
    String newInternalStaff();

    @DefaultStringValue("Accounts")
    String accounts();

    @DefaultStringValue("Time")
    String time();

    @DefaultStringValue("Create Bank Account")
    String createNewBankAccount();

    @DefaultStringValue("Edit Bank Account")
    String editBankAccount();

    @DefaultStringValue("Project")
    String project();

    @DefaultStringValue("Task")
    String task();

    @DefaultStringValue("Most Recent Expenses")
    String mostRecentExpenses();

    @DefaultStringValue("Most Recent Estimates")
    String mostRecentEstimates();

    @DefaultStringValue("Most Recent Invoices")
    String mostRecentInvoices();

    @DefaultStringValue("Product/Service")
    String productService();

    @DefaultStringValue("New Expense")
    String newExpense();

    @DefaultStringValue("Edit Expense")
    String editExpense();

    @DefaultStringValue("Edit Estimate")
    String editEstimate();

    @DefaultStringValue("New Estimate")
    String newEstimate();

    @DefaultStringValue("View Time Entries")
    String viewTimeEntries();

    @DefaultStringValue("New internal")
    String newInternal();

    @DefaultStringValue("Edit internal")
    String editInternal();

    @DefaultStringValue("Manage Tasks")
    String manageTasks();

    @DefaultStringValue("Edit Tasks")
    String editTask();

    @DefaultStringValue("New Tax")
    String newTax();

    @DefaultStringValue("Edit Tax")
    String editTax();

    @DefaultStringValue("Suspend Users")
    String suspendUsers();

    @DefaultStringValue("Reactivate Users")
    String unsuspendUsers();

    @DefaultStringValue("Delete Users")
    String deleteUsers();

    @DefaultStringValue("Delete Invoices")
    String deleteInvoices();

    @DefaultStringValue("Invoice To Client")
    String convertToInvoices();

    @DefaultStringValue("Delete Products")
    String deleteProducts();

    @DefaultStringValue("Delete Services")
    String deleteServices();

    @DefaultStringValue("Archive Expenses")
    String archiveExpenses();

    @DefaultStringValue("Pay Expenses")
    String payExpenses();

    @DefaultStringValue("Delete Expenses")
    String deleteExpenses();

    @DefaultStringValue("Raise Invoices")
    String raiseInvoices();

    @DefaultStringValue("Raise Estimates")
    String raiseEstimates();

    @DefaultStringValue("Raise Expenses")
    String raiseExpenses();

    @DefaultStringValue("Delete Clients")
    String deleteClients();

    @DefaultStringValue("Delete Time Entries")
    String deleteTimeEntries();

    @DefaultStringValue("Delete Projects")
    String deleteProjects();

    @DefaultStringValue("Delete Tasks")
    String deleteTasks();

    @DefaultStringValue("Delete Bank Accounts")
    String deleteBankAccounts();

    @DefaultStringValue("Delete Staff")
    String deleteStaff();

    @DefaultStringValue("Manage Internals")
    String manageInternals();

    @DefaultStringValue("Manage Contractors")
    String manageContractors();

    @DefaultStringValue("Bulk Actions")
    String bulkAction();

    @DefaultStringValue("Delete Suppliers")
    String deleteSuppliers();

    @DefaultStringValue("Delete Estimates")
    String deleteEstimates();

    @DefaultStringValue("Archive Invoices")
    String archiveInvoices();

    @DefaultStringValue("Manage Products")
    String manageProducts();

    @DefaultStringValue("Manage Bank Accounts")
    String manageBankAccounts();

    @DefaultStringValue("Manage Suppliers")
    String manageSuppliers();

    @DefaultStringValue("Manage Services")
    String manageServices();

    @DefaultStringValue("Mark as Completed")
    String completeInvoices();

    @DefaultStringValue("Mark as Overdue")
    String overdueInvoices();

    @DefaultStringValue("Mark as Paid")
    String markAsPaid();

    @DefaultStringValue("Mark as Archived")
    String markAsArchived();

    @DefaultStringValue("Paid Invoices")
    String paidInvoices();

    @DefaultStringValue("Hours")
    String hours();

    @DefaultStringValue("First Day of the Week")
    String firstDayOfWeek();

    @DefaultStringValue("Today")
    String today();

    @DefaultStringValue("Hours Circle Basis")
    String hoursCircleBasis();

    @DefaultStringValue("Date Time Format")
    String dateTimeFormat();

    @DefaultStringValue("Date Format")
    String dateFormat();

    @DefaultStringValue("Search Clients")
    String searchClients();

    @DefaultStringValue("Search Suppliers")
    String searchSuppliers();

    @DefaultStringValue("Search Products")
    String searchProduct();

    @DefaultStringValue("Search Services")
    String searchService();

    @DefaultStringValue("Search Contractors")
    String searchContractor();

    @DefaultStringValue("Search Internal Staff")
    String searchInternalStaff();

    @DefaultStringValue("Search Contractors")
    String searchContractors();

    @DefaultStringValue("Company email")
    String companyEmail();

    @DefaultStringValue("Company phone")
    String companyPhone();

    @DefaultStringValue("Email")
    String email();

    @DefaultStringValue("Mobile")
    String mobile();

    @DefaultStringValue("Zip Code")
    String zip();

    @DefaultStringValue("City")
    String city();

    @DefaultStringValue("Search Internals")
    String searchInternals();

    @DefaultStringValue("Search Projects")
    String searchProjects();

    @DefaultStringValue("Search Tasks")
    String searchTasks();

    @DefaultStringValue("Partner saved successfully")
    String partnerSavedSuccessfully();

    @DefaultStringValue("Invoice raised")
    String invoiceRaised();

    @DefaultStringValue("Expense raised")
    String expenseRaised();

    @DefaultStringValue("Client deleted")
    String clientDeleted();

    @DefaultStringValue("Estimate raised")
    String estimateRaised();

    @DefaultStringValue("Suppliers deleted")
    String suppliersDeleted();

    @DefaultStringValue("Estimate archived")
    String estimateArchived();

    @DefaultStringValue("Documents deleted")
    String documentsDeleted();

    @DefaultStringValue("Estimates converted")
    String estimatesConverted();

    @DefaultStringValue("Product saved")
    String productSaved();

    @DefaultStringValue("Service saved")
    String serviceSaved();

    @DefaultStringValue("Staff member saved")
    String staffSaved();

    @DefaultStringValue("Tax info saved")
    String taxInfoSaved();

    @DefaultStringValue("Document saved")
    String documentSaved();

    @DefaultStringValue("Invoice sent by email")
    String invoiceSentByEmail();

    @DefaultStringValue("Billing Rate")
    String billingRate();

    @DefaultStringValue("Time Unit")
    String timeUnit();

    @DefaultStringValue("Fax")
    String fax();

    @DefaultStringValue("Project Flat Amount")
    String projectFlatAmount();

    @DefaultStringValue("Staff Rate")
    String staffRate();

    @DefaultStringValue("Project Rate")
    String projectRate();

    @DefaultStringValue("Task Rate")
    String taskRate();

    @DefaultStringValue("Hours to bill")
    String hoursNotBilled();

    @DefaultStringValue("Value to bill")
    String valueToBill();

    @DefaultStringValue("Invoice generated")
    String invoiceGenerated();

    @DefaultStringValue("Billed")
    String billed();

    @DefaultStringValue("Time entry already billed")
    String timeEntryAlreadyBilled();

    @DefaultStringValue("Your browser does not seem to have a PDF plugin installed. Please install one from <a href='http://www.adobe.com'>www.adobe.com</a>.")
    String invoicePdfCannotBeEmbedded();

    @DefaultStringValue("New Time Entry")
    String newTimeLog();

    @DefaultStringValue("Edit Time Entry")
    String editTimeLog();

    @DefaultStringValue("Create New Category")
    String createNewCategory();

    @DefaultStringValue("Manage Categories")
    String manageCategories();

    @DefaultStringValue("Delete Categories")
    String deleteCategories();

    @DefaultStringValue("Category saved")
    String categorySaved();

    @DefaultStringValue("Edit Category")
    String editCategory();

    @DefaultStringValue("Search Categories")
    String searchCategories();

    @DefaultStringValue("Expenses already billed or paid")
    String expenseAlreadyBilledOrPaid();

    @DefaultStringValue("Amount")
    String amount();

    @DefaultStringValue("Category")
    String category();

    @DefaultStringValue("Time Entries saved as billed")
    String timeEntrySavedAsBilled();

    @DefaultStringValue("No Time Entries or expenses to be invoiced")
    String noHoursAndExpensesToInvoice();

    @DefaultStringValue("Expenses saved as billed")
    String expensesSavedAsBilled();

    @DefaultStringValue("Reports")
    String reports();

    @DefaultStringValue("Edit User")
    String editUser();

    @DefaultStringValue("Search Bank Accounts")
    String searchBankAccounts();

    @DefaultStringValue("Bank account saved")
    String bankAccountSaved();

    @DefaultStringValue("New Bank Transaction")
    String newBankTransaction();

    @DefaultStringValue("Edit Bank Transaction")
    String editBankTransaction();

    @DefaultStringValue("Flat Price")
    String flatPrice();

    @DefaultStringValue("Cannot convert invoice currency into ba currency")
    String cannotConvertInvoiceCurrencyIntoBaCurrency();

    @DefaultStringValue("Archived Invoices")
    String archivedInvoices();

    @DefaultStringValue("Archived Estimates")
    String archivedEstimates();

    @DefaultStringValue("Please check at least one row")
    String oneRow();

    @DefaultStringValue("Error deleting items")
    String errorDeleting();

    @DefaultStringValue("Items deleted")
    String itemsDeleted();

    @DefaultStringValue("Code")
    String code();

    @DefaultStringValue("Project currency mismatch. Provide conversion")
    String projectCurrencyMismatch();

    @DefaultStringValue("No value to invoice.")
    String noValueToInvoice();

    @DefaultStringValue("Bank Account")
    String bankAccount();

    @DefaultStringValue("Id")
    String id();


    @DefaultStringValue("Account Name")
    String accountName();

    @DefaultStringValue("Reference Account Name")
    String referenceAccountName();

    @DefaultStringValue("Group")
    String group();

    @DefaultStringValue("Hours error.")
    String hoursNotInDailyRange();

    @DefaultStringValue("Bank transaction saved")
    String bankTransactionSaved();

    @DefaultStringValue("Home")
    String home();

    @DefaultStringValue("Title")
    String title();

    @DefaultStringValue("Account")
    String accountClass();


    @DefaultStringValue("Manage Tax Info")
    String manageTaxInfos();

    @DefaultStringValue("Delete Tax Info")
    String deleteTaxInfos();

    @DefaultStringValue("Create Tax Info")
    String createNewTaxInfo();

    @DefaultStringValue("Edit Tax Info")
    String editTaxInfo();

    @DefaultStringValue("Save Tax Info")
    String taxinfoSaved();

    @DefaultStringValue("Percentage")
    String percent();

    @DefaultStringValue("Value")
    String value();

    @DefaultStringValue("Date Raised")
    String dateRaised();

    @DefaultStringValue("Account Number")
    String accountNumber();

    @DefaultStringValue("Bank Name")
    String bankName();

    @DefaultStringValue("Name On Account")
    String nameOnAccount();

    @DefaultStringValue("New/Edit Receipts")
    String newEditReceipts();

    @DefaultStringValue("Ledger")
    String ledger();

    @DefaultStringValue("DEBIT | CREDIT")
    String debitCredit();

    @DefaultStringValue("Accounting Legs")
    String accountingLegs();

    @DefaultStringValue("Balance")
    String balance();

    @DefaultStringValue("Account Ledger Balance")
    String ledgerBalance();

    @DefaultStringValue("Account Type")
    String accountType();

    @DefaultStringValue("Debit")
    String debit();

    @DefaultStringValue("Credit")
    String credit();

    @DefaultStringValue("Create Client/Supplier")
    String newClientSupplier();

    @DefaultStringValue("Cost of Sales")
    String costOfSales();

    @DefaultStringValue("Gross Profit")
    String grossProfits();

    @DefaultStringValue("Operating Profit")
    String operatingProfit();

    @DefaultStringValue("Sales")
    String sales();

    @DefaultStringValue("Total Expenses")
    String totalExpenses();

    @DefaultStringValue("Invoices")
    String invoices();

    @DefaultStringValue("Estimates")
    String estimates();

    @DefaultStringValue("Supplier Expenses")
    String expenses();

    @DefaultStringValue("Receipts")
    String receipts();

    @DefaultStringValue("Settings")
    String settings();

    @DefaultStringValue("Team")
    String teamStatus();

    @DefaultStringValue("Reimburse Staff")
    String reimburseStaff();

    @DefaultStringValue("Direct Payment")
    String directPayment();

    @DefaultStringValue("Direct Payment made to staff")
    String expensesPaidToStaff();

    @DefaultStringValue("No entries to display")
    String noEntriesToDisplay();

    @DefaultStringValue("Reimbursed")
    String reimbursed();

    @DefaultStringValue("Currency Conversion is temporarily not available. Retry.")
    String currencyConversionNA();

    @DefaultStringValue("Reject Expenses")
    String expenseRejected();

    @DefaultStringValue("Archived Expenses")
    String expenseArchived();

    @DefaultStringValue("Project : ")
    String projectIs();

    @DefaultStringValue("Category : ")
    String categoryIs();

    @DefaultStringValue("Expense by : ")
    String expenseReceiptBy();

    @DefaultStringValue(" hours * ")
    String hoursPer();

    @DefaultStringValue(" houry rate")
    String hourlyRate();

    @DefaultStringValue("Task : ")
    String taskIs();

    @DefaultStringValue("Staff : ")
    String staffIs();

    @DefaultStringValue("Expense Processed")
    String expensesProcessed();

    @DefaultStringValue("Feedback")
    String feedback();

    @DefaultStringValue("Report Bug")
    String ReportBug();

    @DefaultStringValue(" We love getting feedback! - it helps us improve Net Numero, \nso if you have any or would like to make any feature requests please use the form below. Thank you!")
    String feedbackMessage();

    @DefaultStringValue("We're here to help! If you require any assistance, encountered a problem, have any feedback for us or would like to make any feature requests please don't hesitate to contact us. Thank you!")
    String reportBugMessage();

    @DefaultStringValue("Currencies Mismatch")
    String currencyMismatch();

    @DefaultStringValue("Pay Supplier")
    String paySupplier();

    @DefaultStringValue("Expense converted to invoice")
    String expenseConvertedToInvoice();

    @DefaultStringValue("Pay Supplier")
    String markAsReimbursed();

    @DefaultStringValue("Accounting")
    String accounting();

    @DefaultStringValue("Bank Transactions")
    String bankTransactions();

    @DefaultStringValue("Transaction Type")
    String transactionType();

    @DefaultStringValue("Currency Converter")
    String currencyConverter();

    @DefaultStringValue("Staff Status")
    String staffStatus();

    // currency converter
    @DefaultStringValue("Exchange rates")
    String exchangeRatesTitle();

    @DefaultStringValue("From amount")
    String fromAmount();

    @DefaultStringValue("Exchange rate")
    String exchange();

    @DefaultStringValue("To amount")
    String toAmount();

    @DefaultStringValue("To nesure all your invoices are professionally created please fill in the details below and you will be ready to go!")
    String wizardMessage();

    @DefaultStringValue("Before you begin...")
    String Wizard();

}

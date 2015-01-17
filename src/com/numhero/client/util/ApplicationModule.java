package com.numhero.client.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.numhero.client.Application;
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
import com.numhero.client.service.DataService;
import com.numhero.client.service.DataServiceAsync;
import com.numhero.shared.enums.InvoiceTypeEnum;
import com.numhero.shared.enums.ProductTypeEnum;
import com.numhero.shared.enums.StaffTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class ApplicationModule extends AbstractGinModule {

    @Override
    protected void configure() {
    }

    @Provides
    DataServiceAsync getDataService() {
        DataServiceAsync asyncService = (DataServiceAsync) GWT.create(DataService.class);
        return asyncService;
    }

    @Provides
    Map<String, String> getRestURLsMap() {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("BankAccount", "bankaccount");
        ret.put("BankTransaction", "banktransaction");
//    	ret.put(BusinessTransaction.class.getName(), "businesstransaction");
        ret.put("Category", "category");
        ret.put("Client", "client");
        ret.put("Supplier", "supplier");
        ret.put("ExpenseReceipt", "pettyexpense");
        ret.put(InvoiceTypeEnum.Estimate.name(), "estimate");
        ret.put(InvoiceTypeEnum.Expense.name(), "expense");
        ret.put(InvoiceTypeEnum.Invoice.name(), "invoice");
//    	ret.put(NominalLedgerAccount.class.getName(), "nominalledgeraccount");
        ret.put(ProductTypeEnum.product.name(), "product");
        ret.put(ProductTypeEnum.service.name(), "service");
        ret.put("Project", "project");
        ret.put(StaffTypeEnum.Contractor.name(), "contractor");
        ret.put(StaffTypeEnum.Internal.name(), "internal");
        ret.put("Task", "task");
        ret.put("TaxInfo", "taxinfo");
//    	ret.put(User.class.getName(), "user");
//    	ret.put(UserMessage.class.getName(), "usermessage");
        return ret;
    }


    //todo Mikado: remove all those when finished with proxies
    @Provides
    ClientsConstants getClientsConst() {
        return Application.getConstants();
    }

    @Provides
    InvoiceConstants getInvoiceConstants() {
        return Application.getConstants();
    }

    @Provides
    TaskConstants getTaskConstants() {
        return Application.getConstants();
    }

    @Provides
    BankAccountConstants getBankAccountConstants() {
        return Application.getConstants();
    }

    @Provides
    BankTransConstants getBankTransConstants() {
        return Application.getConstants();
    }

    @Provides
    CategoryConstants getCategoryConstants() {
        return Application.getConstants();
    }


    @Provides
    ProductConstants getProductConstants() {
        return Application.getConstants();
    }

    @Provides
    ServiceConstants getServiceConstants() {
        return Application.getConstants();
    }


    @Provides
    StaffConstants getStaffConstants() {
        return Application.getConstants();
    }

    @Provides
    TaxInfoConstants getTaxInfoConstants() {
        return Application.getConstants();
    }

    @Provides
    TimeEntryConstants getTimeEntryConstants() {
        return Application.getConstants();
    }

    @Provides
    ProjectConstants getProjectConstants() {
        return Application.getConstants();
    }

    @Provides
    ExpenseReceiptConstants  getExpenseReceiptConstants() {
        return Application.getConstants();
    }

}

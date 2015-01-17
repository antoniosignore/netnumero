package com.numhero.client.mvp.expense;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextArea;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.client.mvp.category.CategorySelect;
import com.numhero.client.mvp.clientsupplier.ClientSelect;
import com.numhero.client.mvp.staff.StaffPanel;
import com.numhero.client.mvp.staff.StaffSelect;
import com.numhero.client.service.Service;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class ExpenseReceiptPanel extends AbstractEditEntityPanel implements DropDownBoxHandler {

    interface ExpenseUiBinder extends UiBinder<HTMLPanel, ExpenseReceiptPanel> {
    }

    private static ExpenseUiBinder uiBinder = GWT.create(ExpenseUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField(provided = true)
    ClientSelect sbClient;

    @UiField(provided = true)
    StaffSelect sbStaff;

    @UiField
    CustomFormatDateBox selectedDate;

    @UiField
    CurrencySelect cbCurrency;

    @UiField
    NumberTextBox amount;

    @UiField
    TextArea notes;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btNew;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    ExpensesTable expensesTable;

    @UiField(provided = true)
    CategorySelect sbCategory;

    @Inject
    public ExpenseReceiptPanel(final Service<ClientListRequest, ClientSupplierListResponse> clientSuppliersService,
                               final Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService,
                               final Service<CategoryListRequest, CategoryListResponse> categoriesService,
                               final Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService,
                               Service<StaffListRequest, StaffListResponse> listStaffService,
                               Service<SaveStaffRequest, SaveStaffResponse> saveStaffService,
                               StaffPanel staffPanel,
                               CategoryPanel panel) {

        sbStaff = new StaffSelect(this, listStaffService, saveStaffService, staffPanel);
        sbClient = new ClientSelect(this, clientSuppliersService, clientSupplierSaveService);
        sbCategory = new CategorySelect(this, categoriesService, categorySaveService, panel);
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
    }

    public ExpenseReceipt getExpense() {
        return (ExpenseReceipt) pojo;
    }

    @Override
    public void itemSelected(Suggestion pojoC) {
        if (pojoC instanceof ClientSupplier) {
            ClientSupplier clientC = (ClientSupplier) pojoC;
            getExpense().fClientSupplierID.setValue(clientC.getId());
            getExpense().fClientSupplierName.setValue(clientC.fName.getValue());
        } else if (pojoC instanceof Staff) {
            Staff clientC = (Staff) pojoC;
            getExpense().fStaffId.setValue(clientC.getId());
            getExpense().fStaffName.setValue(clientC.fName.getValue());
        } else if (pojoC instanceof Category) {
            Category clientC = (Category) pojoC;
            getExpense().fCategoryID.setValue(clientC.getId());
            getExpense().fCategoryName.setValue(clientC.fName.getValue());
        }
    }

    public TextArea getNotes() {
        return notes;
    }

    public void setNotes(TextArea notes) {
        this.notes = notes;
    }

    public NetNumeroButton getBtSearch() {
        return btSave;
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            resetValidator();
            getExpense().fClientSupplierID.setValue((sbClient.getPojo().getId()));
            getExpense().fClientSupplierName.setValue(sbClient.getPojo().fName.getValue());

            getExpense().fStaffId.setValue((sbStaff.getPojo().getId()));
            getExpense().fStaffName.setValue(sbStaff.getPojo().fName.getValue());

            getExpense().fCategoryID.setValue((sbCategory.getPojo().getId()));
            getExpense().fCategoryName.setValue(sbCategory.getPojo().fName.getValue());

//            getExpense().fInvoiceStatus.setValue(InvoiceStatusEnum.Unbilled);
//            getExpense().fReceiptStatus.setValue(ReceiptStatusEnum.Unbilled);
            //ReceiptStatusEnum

            getExpense().fValue.setValue(getAmount().getAmount());
            getExpense().fNotes.setValue(getNotes().getValue());
            getExpense().fCurrency.setValue(cbCurrency.getPojo());
            getExpense().fDate.setValue(selectedDate.getValue());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        notes.setValue(getExpense().fNotes.getValue());
        amount.setAmount(getExpense().fValue.getValue());
        sbClient.setClientSupplier(getExpense().fClientSupplierID.getValue(), getExpense().fClientSupplierName.getValue());
        sbCategory.setCategory(getExpense().fCategoryID.getValue(), getExpense().fCategoryName.getValue());
        sbStaff.getSuggestBox().setText(getExpense().fStaffName.getValue());
        cbCurrency.setPojo(getExpense().fCurrency.getValue());
        selectedDate.setValue(getExpense().fDate.getValue());
    }

    protected DisclosurePanel getErrorsPanel() {
        return errorsPanel;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public ClientSelect getSbClient() {
        return sbClient;
    }

    public void setSbClient(ClientSelect sbClient) {
        this.sbClient = sbClient;
    }

    public StaffSelect getSbStaff() {
        return sbStaff;
    }

    public void setSbStaff(StaffSelect sbStaff) {
        this.sbStaff = sbStaff;
    }

    public CategorySelect getSbCategory() {
        return sbCategory;
    }

    public void setSbCategory(CategorySelect sbCategory) {
        this.sbCategory = sbCategory;
    }

    public CustomFormatDateBox getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(CustomFormatDateBox selectedDate) {
        this.selectedDate = selectedDate;
    }

    public ExpensesTable getExpensesTable() {
        return expensesTable;
    }

    public void setExpensesTable(ExpensesTable expensesTable) {
        this.expensesTable = expensesTable;
    }

    public NumberTextBox getAmount() {
        return amount;
    }

    public void setAmount(NumberTextBox amount) {
        this.amount = amount;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public NetNumeroButton getBtNew() {
        return btNew;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    protected void addValidators() {
        FocusAction focusAction = new FocusAction();

        validator.addValidators(Application.getConstants().client(),
                new NotEmptyValidator(sbClient.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).
                        addActionForFailure(new StyleAction("validation-failed")));

        validator.addValidators(Application.getConstants().category(),
                new NotEmptyValidator(sbCategory.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).addActionForFailure(new StyleAction("validation-failed")));

        validator.addValidators(Application.getConstants().staff(),
                new NotEmptyValidator(sbStaff.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).
                        addActionForFailure(new StyleAction("validation-failed")));

    }

}

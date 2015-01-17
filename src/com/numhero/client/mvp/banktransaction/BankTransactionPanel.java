package com.numhero.client.mvp.banktransaction;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.mvp.bankaccount.BankAccountPanel;
import com.numhero.client.mvp.bankaccount.BankAccountSelect;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.client.mvp.category.CategorySelect;
import com.numhero.client.service.Service;
import com.numhero.client.util.CoreUtils;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.TransactionEnum;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class BankTransactionPanel extends AbstractEditEntityPanel implements DropDownBoxHandler {

    interface BankTransactionUiBinder extends UiBinder<HTMLPanel, BankTransactionPanel> {
    }

    private static BankTransactionUiBinder uiBinder = GWT.create(BankTransactionUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    CustomFormatDateBox selectedDate;

    @UiField(provided = true)
    CategorySelect sbCategory;

    @UiField
    Label currency;

    @UiField
    NumberTextBox amount;

    @UiField
    TextArea notes;

    @UiField
    RadioButton isDeposit;

    @UiField
    RadioButton isWithdraw;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    @UiField(provided = true)
    BankAccountSelect sbBankAccount;

//    @UiField
//    TableRowElement bankPanel;
//
//    @UiField
    //    BankAccountPanel bankAccountPanel;
//
//    @UiField
//    TableRowElement bankLabel;
//
    BankAccount ba;

    @Inject
    public BankTransactionPanel(Service<BankAccountListRequest, BankAccountListResponse> bankAccountListervice,
                                Service<SaveBankAccountRequest, SaveBankAccountResponse> requestSaveBankAccountService,
                                BankAccountPanel bankAccountPanel,
                                Service<CategoryListRequest, CategoryListResponse> categoriesService,
                                Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService,
                                CategoryPanel panel) {

        sbBankAccount = new BankAccountSelect(this, bankAccountListervice, requestSaveBankAccountService, bankAccountPanel);

        sbCategory = new CategorySelect(this, categoriesService, categorySaveService, panel);

        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);

    }

    public BankTransaction getBankTransaction() {
        return (BankTransaction) pojo;
    }

    @Override
    public void itemSelected(Suggestion pojo) {
        if (pojo instanceof BankAccount) {
            ba = (BankAccount) pojo;
            getBankTransaction().fBankAccountId.setValue(ba.getId());
            getBankTransaction().fBankAccountName.setValue(ba.fName.getValue());
            getBankTransaction().fCurrency.setValue(ba.fCurrency.getValue());
            currency.setText(ba.fCurrency.getValueAsString());
        } else if (pojo instanceof Category) {
            Category category = (Category) pojo;
            getBankTransaction().setAccountID(category.getId());
            getBankTransaction().setAccountName(category.fName.getValue());
        }
    }

//    public TableRowElement getBankLabel() {
//        return bankLabel;
//    }

    public TextArea getNotes() {
        return notes;
    }

    public Label getCurrency() {
        return currency;
    }

    public void setCurrency(Label currency) {
        this.currency = currency;
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            getBankTransaction().fBankAccountId.setValue((sbBankAccount.getPojo().getId()));
            getBankTransaction().fBankAccountName.setValue(sbBankAccount.getPojo().fName.getValue());
            getBankTransaction().fDate.setValue(selectedDate.getValue());
            getBankTransaction().fValue.setValue(amount.getAmount());
            getBankTransaction().fNotes.setValue(getNotes().getValue());
            //CoreUtils.debug("===============> CurrencyEnum.getByValue(currency.getText()) = " + CurrencyEnum.getByValue(currency.getText()));
            getBankTransaction().fCurrency.setValue(CurrencyEnum.valueOf(currency.getText()));
            getBankTransaction().fType.setValue((isDeposit.getValue() ? TransactionEnum.deposit : TransactionEnum.withdraw));
            getBankTransaction().setAccountID(sbCategory.getPojo().getId());
            getBankTransaction().setAccountName(sbCategory.getPojo().getName());
            CoreUtils.debug("===============> getBankTransaction().setAccountID(sbCategory.getPojo().getId()); = " + sbCategory.getPojo().getId());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        notes.setValue(getBankTransaction().fNotes.getValue());
        amount.setAmount(getBankTransaction().fValue.getValue());
        sbBankAccount.setBankAccount(getBankTransaction().fBankAccountId.getValue(), getBankTransaction().fBankAccountName.getValue());
        currency.setText(getBankTransaction().fCurrency.getValueAsString());
        selectedDate.setValue(getBankTransaction().fDate.getValue());

        Category cat = (Category) sbCategory.getPojo();
        cat.setId(getBankTransaction().getAccountID());
        cat.fName.setValue(getBankTransaction().getAccountName());
        sbCategory.getSuggestBox().setValue(getBankTransaction().getAccountName());

        TransactionEnum en = getBankTransaction().fType.getValue();
        if (en == TransactionEnum.deposit) {
            isDeposit.setValue(true);
            isWithdraw.setValue(false);
        } else {
            isDeposit.setValue(false);
            isWithdraw.setValue(true);
        }
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public CustomFormatDateBox getSelectedDate() {
        return selectedDate;
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

    public BankAccountSelect getSbBankAccount() {
        return sbBankAccount;
    }

    @Override
    protected void addValidators() {

        FocusAction focusAction = new FocusAction();

        validator.addValidators(Application.getConstants().bankAccount(),
                new NotEmptyValidator(sbBankAccount.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).addActionForFailure(
                        new StyleAction("validation-failed")));

        validator.addValidators(Application.getConstants().category(),
                new NotEmptyValidator(sbCategory.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).addActionForFailure(
                        new StyleAction("validation-failed")));
    }

}

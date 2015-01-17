package com.numhero.client.mvp.banktransaction;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountResponse;
import com.numhero.client.model.datacargo.banktransaction.GetBankTransactionRequest;
import com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericAccountsTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

import java.util.Date;

@Singleton
public class BankTransactionPresenter extends EditPresenter {

    private Service<GetBankTransactionRequest, GetBankTransactionResponse> bankTransactionGetService;
    private Service<SaveBankTransactionRequest, SaveBankTransactionResponse> transactionSaveService;
    private Service<GetMainTradingBankAccountRequest, GetMainTradingBankAccountResponse> bankMainTradingAccountGetService;
    private BankTransConstants constants;

    @Inject
    public BankTransactionPresenter(PlaceManager eventManager,
                                    Service<GetBankTransactionRequest, GetBankTransactionResponse> bankTransactionGetService,
                                    Service<SaveBankTransactionRequest, SaveBankTransactionResponse> transactionSaveService,
                                    BankTransactionPanel expensePanel,
                                    Service<GetMainTradingBankAccountRequest, GetMainTradingBankAccountResponse> bankMainTradingAccountGetService,
                                    BankTransConstants constants) {
        super(eventManager, new GenericAccountsTabEditPage(expensePanel));
        this.bankTransactionGetService = bankTransactionGetService;
        this.transactionSaveService = transactionSaveService;
        this.bankMainTradingAccountGetService = bankMainTradingAccountGetService;
        this.constants = constants;
    }

    private BankTransactionPanel getBankTransactionPanel() {
        return ((BankTransactionPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {

            GetMainTradingBankAccountRequest request = new GetMainTradingBankAccountRequest();
            request.setEntityId(getBankTransactionPanel().getSbBankAccount().getPojo().fId.getValue());
            bankMainTradingAccountGetService.execute(request, new ServiceCallbackImpl<GetMainTradingBankAccountResponse>() {
                @Override
                public void onSuccess(GetMainTradingBankAccountResponse response) {
                    BankTransaction transaction = new BankTransaction();
                    transaction.fCurrency.setValue(response.getEntity().fCurrency.getValue());
                    getBankTransactionPanel().setPojo(transaction);
                    getBankTransactionPanel().getSbBankAccount().setPojo(response.getEntity());
                    getView().setDetailTitlePanel(constants.newBankTransaction());
                }
            });
        } else {
            getView().setDetailTitlePanel(constants.editBankTransaction());
            GetBankTransactionRequest request = new GetBankTransactionRequest();
            request.setEntityId(getUrl().getId());
            bankTransactionGetService.execute(request, new ServiceCallbackImpl<GetBankTransactionResponse>() {
                @Override
                public void onSuccess(GetBankTransactionResponse response) {
                    getBankTransactionPanel().setPojo(response.getEntity());
                }
            });
        }
//        getBankTransactionPanel().getBankPanel().setClassName("row-collapse");
    }

    private ClickHandler saveBankTransactionHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getBankTransactionPanel().saveValuesFromUi()) {
                    SaveBankTransactionRequest request = new SaveBankTransactionRequest();
                    request.setBankTransaction(getBankTransactionPanel().getBankTransaction());
                    Application.showGlasspanelLoading();
                    transactionSaveService.execute(request, new ServiceCallbackImpl<SaveBankTransactionResponse>() {
                        @Override
                        public void onSuccess(SaveBankTransactionResponse response) {
                            Application.toasterMessage(constants.bankTransactionSaved());
                            redirect();
                        }
                    });
                }
            }
        };
        return ret;
    }

    @Override
    protected void onBind() {
        super.onBind();
        final BankTransactionPanel panel = getBankTransactionPanel();
        panel.getSelectedDate().setValue(new Date());
        panel.getBtSave().addClickHandler(saveBankTransactionHandler());
        panel.getBtCancel().setHref("#bank-transactions");
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    @Override
    protected String getReturnUrl() {
        return "bank-transactions";
    }
}

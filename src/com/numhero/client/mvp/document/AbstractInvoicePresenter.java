package com.numhero.client.mvp.document;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SendInvoiceRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.numhero.client.Application.getConstants;

public abstract class AbstractInvoicePresenter extends EditPresenter {
    private Service<GetInvoiceRequest, GetSingleEntityResponse<Invoice>> getService;
    private Service<SaveInvoiceRequest, SaveSingleEntityResponse> saveService;
    private Service<SendInvoiceRequest, SaveSingleEntityResponse> sendService;

    private Invoice invoice;

    protected AbstractInvoicePresenter(
            PlaceManager eventManager,
            Service<GetInvoiceRequest, GetSingleEntityResponse<Invoice>> getService,
            Service<SaveInvoiceRequest, SaveSingleEntityResponse> saveService,
            Service<SendInvoiceRequest, SaveSingleEntityResponse> sendService,
            InvoiceEditPageView view) {
        super(eventManager, view);

        this.getService = getService;
        this.saveService = saveService;
        this.sendService = sendService;

    }


    @Override
    public InvoiceEditPageView getView() {
        return (InvoiceEditPageView) super.getView();
    }

    protected abstract Invoice createInvoice();

    @Override
    public void onShow() {
        Application.injector.getClientCache().useCache(new TaxInfoListRequest(), new ServiceCallbackImpl<CommandResponse>() {
            @Override
            public void onSuccess(CommandResponse response) {
                Map<Long, TaxInfo> taxes = createMap((TaxInfoListResponse) response);
                setTaxes(taxes);
                internalShow();
            }
        });
    }

    private void setTaxes(Map<Long, TaxInfo> taxes) {
        getView().setTaxes(taxes);
    }

//    private AbstractInvoicePanel getInvoiceEditPanel() {
//        Widget contentWidget = getView().getContentPanel().getContentWidget();
//
//        if (contentWidget != editPanel) {
//            getView().getContentPanel().setContentWidget(editPanel);
//        }
//        return editPanel;
//    }

    protected Map<Long, TaxInfo> createMap(TaxInfoListResponse response) {
        Map<Long, TaxInfo> m = new HashMap<Long, TaxInfo>();
        Collection<TaxInfo> l = response.getEntityList();
        for (TaxInfo taxInfo : l) {
            m.put(taxInfo.getId(), taxInfo);
        }
        return m;
    }

    @Override
    protected void onBind() {

        getView().addSaveClickHandler(btSaveDraftHandler());
        getView().addSendAsEmailClickHandler(btSendByEmail());
        getView().addSendAsSnailClickHandler(btSendSnailMail());
        getView().addCanceltHref("#" + getReturnUrl());

    }


    private void internalShow() {


        Long id = getUrl().getId();
        if (id == null) {
            getView().setDetailTitlePanel(getDetailTitlePanelNewEntity());
            invoice = createInvoice();
            setEditPojo();
            getView().setViewMode();
        } else {
            getView().setDetailTitlePanel(getDetailTitlePanelEditEntity());
            GetInvoiceRequest request = new GetInvoiceRequest(id);
            getService.execute(request, new ServiceCallbackImpl<GetSingleEntityResponse<Invoice>>() {
                @Override
                public void onSuccess(GetSingleEntityResponse<Invoice> response) {
                    invoice = response.getEntity();

                    if (invoice == null) throw new IllegalStateException("No entity in response");

                    setEditPojo();
                    if (invoice.getInvoiceStatus() == InvoiceStatusEnum.Draft) {

                        getView().setEditMode();
                    } else {
                        getView().setViewPdfMode();

                        getView().setDetailTitlePanel(getDetailTitlePanelViewEntity());
                    }
                }
            });
        }
    }

    protected abstract String getDetailTitlePanelNewEntity();

    protected abstract String getDetailTitlePanelEditEntity();

    protected abstract String getDetailTitlePanelViewEntity();


    private void setEditPojo() {
        if (invoice == null) throw new IllegalStateException("invoice cannot be null");
        getView().setPojo(invoice);
    }

    private ClickHandler btSaveDraftHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getView().saveValuesFromUi()) {
                    invoice.setInvoiceStatus(InvoiceStatusEnum.Draft);
                    callSaveService(callbackForSave(getConstants().documentSaved()));
                }
            }
        };
        return ret;
    }

    private ClickHandler btSendSnailMail() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getView().saveValuesFromUi()) {
                    invoice.setInvoiceStatus(InvoiceStatusEnum.Sent);
                    callSaveService(callbackForPrinting());
                }
            }
        };
        return ret;
    }

    private ClickHandler btSendByEmail() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getView().saveValuesFromUi()) {
                    SendInvoiceRequest request = new SendInvoiceRequest();
                    request.setEntity(invoice);
                    invoice.setInvoiceStatus(InvoiceStatusEnum.Sent);
                    Application.showGlasspanelLoading();
                    sendService.execute(request, callbackForSave(getConstants().invoiceSentByEmail()));
                }
            }
        };
        return ret;
    }

    private void callSaveService(ServiceCallbackImpl<SaveSingleEntityResponse> callback) {
        SaveInvoiceRequest request = new SaveInvoiceRequest();
        request.setEntity(invoice);
        Application.showGlasspanelLoading();
        saveService.execute(request, callback);
    }

    private ServiceCallbackImpl<SaveSingleEntityResponse> callbackForSave(final String successMsg) {
        return new ServiceCallbackImpl<SaveSingleEntityResponse>() {
            @Override
            public void onSuccess(SaveSingleEntityResponse response) {
                Application.toasterMessage(successMsg);
                redirect();
            }
        };
    }

    private ServiceCallbackImpl<SaveSingleEntityResponse> callbackForPrinting() {
        return new ServiceCallbackImpl<SaveSingleEntityResponse>() {
            @Override
            public void onSuccess(SaveSingleEntityResponse response) {
                redirect();
                //todo Mikado: this seems broken...
                ClientUtils.openPdf("/pdf/" + response.getEntityId());
            }
        };
    }
}

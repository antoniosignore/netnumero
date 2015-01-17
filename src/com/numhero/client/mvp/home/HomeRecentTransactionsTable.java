package com.numhero.client.mvp.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.client.mvp.accounting.LegsDialog;
import com.numhero.client.mvp.accounting.LegsPanel;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.CoreUtils;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.shared.enums.ReferenceDocEnum;

import java.util.List;

public class HomeRecentTransactionsTable extends FlexTableWithHeader {

    List<BusinessTransaction> transactions;

    public HomeRecentTransactionsTable() {
        setStyleName("inh-standard-recap");
        setHeader();
    }

    public void setTransactions(List<BusinessTransaction> entries,
                                Service<GetBusinessTransactionRequest, GetBusinessTransactionResponse> getBusinessTransactionService) {
        removeAllRows();
        this.transactions = entries;
        if (this.transactions != null) {
            int row = 0;
            while (row < entries.size()) {
                BusinessTransaction bizTrans = entries.get(row);

                Anchor l = entryDialogBox(bizTrans, getBusinessTransactionService);
                setText(row, 0, DateTimeFormat.getShortDateFormat().format(bizTrans.fDate.getValue()));

                HTML hID = null;
                if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.Invoice) {
                    hID = new HTML("<a href='#invoice/" + bizTrans.fReferenceDocId.getValue() + "'>" + bizTrans.fBusinessTransaction.getValueAsString() + "</a>");
                    setWidget(row, 1, hID);
                } else if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.BankTransaction) {
                    hID = new HTML("<a href='#bank-transaction/" + bizTrans.fReferenceDocId.getValue() + "'>" + bizTrans.fBusinessTransaction.getValueAsString() + "</a>");
                    setWidget(row, 1, hID);
                } else if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.Expense) {
                    hID = new HTML("<a href='#expense/" + bizTrans.fReferenceDocId.getValue() + "'>" + bizTrans.fBusinessTransaction.getValueAsString() + "</a>");
                    setWidget(row, 1, hID);
                }

                setText(row, 2, bizTrans.fDescription.getValue());
                setWidget(row, 3, l);
                row++;
            }
        }
        addEmptyStatus();
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "40px");
        setHeader(1, Application.getConstants().type(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
        setHeader(3, "", HasHorizontalAlignment.ALIGN_LEFT, "0px");
    }

    private Anchor entryDialogBox(final BusinessTransaction entry,
                                  final Service<GetBusinessTransactionRequest, GetBusinessTransactionResponse> getBusinessTransactionService) {
        Anchor l = new Anchor("Details", false);
        l.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                GetBusinessTransactionRequest request = new GetBusinessTransactionRequest();
                request.setEntityId(entry.getId());
                getBusinessTransactionService.execute(request, new ServiceCallbackImpl<GetBusinessTransactionResponse>() {
                    @Override
                    public void onSuccess(GetBusinessTransactionResponse getBusinessTransactionResponse) {

                        final LegsPanel panel = new LegsPanel();
                        final BusinessTransaction bizTrans = getBusinessTransactionResponse.getEntity();
                        panel.getLegsTable().setEntry(bizTrans);

                        panel.getTbBusinessTransactionEnum().setText(bizTrans.fBusinessTransaction.getValueAsString());
                        if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.Invoice) {
                            panel.getTbReferenceDoc().setText("invoice");
                        } else if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.BankTransaction) {
                            panel.getTbReferenceDoc().setText("bank-transaction");
                        } else if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.Expense) {
                            panel.getTbReferenceDoc().setText("expense");
                        }

                        final LegsDialog dialog = new LegsDialog(panel);

                        panel.getTbReferenceDoc().addClickHandler(new ClickHandler() {
                            @Override
                            public void onClick(ClickEvent event) {
                                CoreUtils.debug("event = " + event);
                                if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.Invoice) {
                                    Application.getPlaceManager().moveToPlace("invoice/" + bizTrans.fReferenceDocId.getValue());
                                } else if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.BankTransaction) {
                                    Application.getPlaceManager().moveToPlace("bank-transaction/" + bizTrans.fReferenceDocId.getValue());
                                } else if (bizTrans.fReferenceDocType.getValue() == ReferenceDocEnum.Expense) {
                                    Application.getPlaceManager().moveToPlace("expense/" + bizTrans.fReferenceDocId.getValue());
                                }
                                dialog.hide();
                            }
                        });

                        panel.getBtCancel().addClickHandler(new ClickHandler() {
                            @Override
                            public void onClick(ClickEvent event) {
                                dialog.hide();
                            }
                        });
                        dialog.center();
                    }
                });


            }
        });
        return l;
    }
}

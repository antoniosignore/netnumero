package com.numhero.client.mvp.reportbug;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.usermessage.SaveUserMessageRequest;
import com.numhero.client.model.datacargo.usermessage.SaveUserMessageResponse;
import com.numhero.client.model.pojoc.UserMessage;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.enums.MessageTypeEnum;

import java.util.Date;

public class ReportBugDialog extends DialogBox {

    @Inject
    Service<SaveUserMessageRequest, SaveUserMessageResponse> saveReportBug;

    public ReportBugDialog() {

        final ReportBugDialog dialog = this;

        final ReportBugPanel panel = new ReportBugPanel();

        panel.getBtCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                dialog.hide();
            }
        });

        panel.getBtSave().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SaveUserMessageRequest request = new SaveUserMessageRequest();
                request.setBusinessAccountId(ClientCache.getCurrentBA().fBusinessAccountUri.getValue());
                UserMessage ReportBug = new UserMessage();
                ReportBug.fMessage.setValue(panel.getTaNotes().getValue());
                ReportBug.fMessageType.setValue(MessageTypeEnum.BugReport);
                ReportBug.fBusinessAccountUri.setValue(ClientCache.getCurrentBA().fBusinessAccountUri.getValue());
                ReportBug.fCreated.setValue(new Date());
                request.setEntity(ReportBug);

                saveReportBug.execute(request, new ServiceCallbackImpl<SaveUserMessageResponse>() {
                    @Override
                    public void onSuccess(SaveUserMessageResponse saveReportBugResponse) {
                        dialog.hide();
                    }
                });
            }
        });

        panel.getMessage().setText(Application.getConstants().reportBugMessage());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setWidget(panel);
        setText(Application.getConstants().ReportBug());
    }
}

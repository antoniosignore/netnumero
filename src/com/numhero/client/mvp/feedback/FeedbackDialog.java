package com.numhero.client.mvp.feedback;

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

public class FeedbackDialog extends DialogBox {

    @Inject
    Service<SaveUserMessageRequest, SaveUserMessageResponse> saveFeedback;

    public FeedbackDialog() {

        final FeedbackDialog dialog = this;

        final FeedbackPanel panel = new FeedbackPanel(); //Application.injector.getFeedbackPanel();

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
                UserMessage userMessage = new UserMessage();
                userMessage.fMessage.setValue(panel.getTaNotes().getValue());
                userMessage.fMessageType.setValue(MessageTypeEnum.Feedback);
                userMessage.fBusinessAccountUri.setValue(ClientCache.getCurrentBA().fBusinessAccountUri.getValue());
                userMessage.fCreated.setValue(new Date());
                request.setEntity(userMessage);

                Application.showGlasspanelLoading();
                saveFeedback.execute(request, new ServiceCallbackImpl<SaveUserMessageResponse>() {
                    @Override
                    public void onSuccess(SaveUserMessageResponse saveUserMessageResponse) {
                        dialog.hide();
                    }
                });
            }
        });

        panel.getMessage().setText(Application.getConstants().feedbackMessage());

        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setWidget(panel);
        setText(Application.getConstants().feedback());
    }
}

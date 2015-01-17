package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.usermessage.SaveUserMessageRequest;
import com.numhero.client.model.datacargo.usermessage.SaveUserMessageResponse;
import com.numhero.client.model.pojoc.UserMessage;
import com.numhero.server.model.daolite.EmailDao;
import com.numhero.server.model.daolite.FeedbackDao;
import com.numhero.server.service.CompanyBuilder;
import com.numhero.server.utils.DaoUtils;

import java.util.Date;
import java.util.logging.Logger;

//import static com.google.appengine.repackaged.com.google.common.base.StringUtil.isEmpty;

public class CommandSaveUserMessage extends AbstractAuthenticatedCommand<SaveUserMessageRequest, SaveUserMessageResponse> {

    private static final Logger log = Logger.getLogger(CommandSaveUserMessage.class.getName());

    @Inject
    FeedbackDao feedbackDao;

    @Inject
    public EmailDao emailDao;

    // save on DB and send also an email if possible...
    @Override
    public SaveUserMessageResponse execute(SaveUserMessageRequest request) {

        UserMessage userMessage = (UserMessage) request.getEntity();
        userMessage.fCreated.setValue(new Date());
        DaoUtils.setData(request, userMessage);
        feedbackDao.save(userMessage);
        SaveUserMessageResponse response = new SaveUserMessageResponse();
        response.setEntityId(userMessage.getId());
        sendByEmail(userMessage, CompanyBuilder.MAILSERVER_NETNUMERO_COM, CompanyBuilder.ADMIN_NETNUMERO_COM);
        return response;
    }

    private void sendByEmail(UserMessage reportbug, String fromEmail, String destEmail) {
        try {
//            if (isEmpty(fromEmail)) {
//                throw new ClientWarningException("noEmailAddressForBA");
//            }

            String msgBody = "Bug Report \n";
            msgBody += reportbug.fCreated.getValue() + "\n";
            msgBody += reportbug.fMessage.getValue() + "\n";
            msgBody += "\n\nby http://www.netnumero.com";

            String subj = "Bug " + reportbug.fBusinessAccountUri.getValue();
            emailDao.sendEmail(fromEmail, destEmail, msgBody, subj, null, null);
        }
        catch (Exception e) {
            log.severe(e.toString() + " -- " + reportbug.toString() + " " + fromEmail + " " + destEmail);
        }
    }
}

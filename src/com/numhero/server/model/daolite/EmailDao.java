package com.numhero.server.model.daolite;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;
import java.util.logging.Logger;

public class EmailDao {

    protected static final Logger log = Logger.getLogger(EmailDao.class.getName());

    public EmailDao() {
    }

    public void sendEmail(String fromEmail, String destEmail, String msgBody, String subj, byte[] attachment, String attachFileName) throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        log.fine("sending email " + subj + " " + fromEmail + " " + destEmail);
        log.fine("msg body " + msgBody);

        if (attachFileName != null) log.fine("sending attachment " + attachFileName + " len:" + attachment.length);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destEmail));
        message.setSubject(subj);
        if (attachFileName != null && attachment.length > 0) {
            Multipart multipart = createMultipart(msgBody, attachment, attachFileName);
            message.setContent(multipart);
        } else {
            message.setText(msgBody);
        }
        Transport.send(message);
    }

    private Multipart createMultipart(String msgBody, byte[] attachmentData, String attachFileName) throws MessagingException {
        Multipart mp = new MimeMultipart();

        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(msgBody, "text/html");
        mp.addBodyPart(htmlPart);

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.setFileName(attachFileName);
//        attachment.setContent(attachmentData, "application/pdf");
        //workaround for gae bug
        //see http://groups.google.com/group/google-appengine-java/browse_thread/thread/e4bc13e091ba2e26/a54e006f0fda4a7e?pli=1
        DataSource src = new ByteArrayDataSource(attachmentData, "application/pdf");
        attachment.setDataHandler(new DataHandler(src));

        mp.addBodyPart(attachment);

        return mp;
    }

}


package net.hmrradio.podcastsite.service;

import java.io.IOException;
import java.util.Date;

import net.hmrradio.podcastsite.model.MailMessage;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailServiceFactory;
import com.google.appengine.api.mail.MailService.Message;

public class MailMessageService {

    public void send(String name, String mailAddress, String content)
            throws IOException {

        // store
        MailMessage mail = new MailMessage();
        mail.setName(name);
        mail.setMailAddress(mailAddress);
        mail.setContent(content);

        send(mail);
    }

    public void send(MailMessage mail) throws IOException {
        // store
        mail.setSendDate(new Date());
        Datastore.put(mail);

        // send
        MailService ms = MailServiceFactory.getMailService();
        Message msg = new Message();
        msg.setTo("hmrblog@gmail.com");
        msg.setSubject("mail");
        msg.setSender("daishi.hmr@gmail.com");
        msg.setTextBody(createTextBody(mail));
        ms.send(msg);
    }

    private String createTextBody(MailMessage mail) {
        StringBuffer result = new StringBuffer();

        result.append("name: " + mail.getName() + "\n");
        result.append("email address: " + mail.getMailAddress() + "\n");
        result.append(mail.getContent());

        return result.toString();
    }

}

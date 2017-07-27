package directdronedelivery.drone.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import directdronedelivery.drone.service.MailService;
import directdronedelivery.exceptions.MailKeys;

/**
 *
 * @author Marcin Stachowiak, Capgemini(marcin.stachowiak@capgemini.com)
 *
 */

@Service
public class MailServiceImpl implements MailService {

    @Override
    public boolean sendEmail(String messageSubject, String messageText, String recipientEmail) {
        Properties props = buildProperties();
        Session session = Session.getInstance(props, buildAuthenticator());
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(messageSubject);
            message.setText(messageText);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private Properties buildProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }

    private Authenticator buildAuthenticator() {
        return new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailKeys.LOGIN, MailKeys.PASSWORD);
            }
        };
    }
}

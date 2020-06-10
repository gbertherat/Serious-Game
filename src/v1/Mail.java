package v1;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public static void sendMail(String destinataire, String titre, String contenu) {
		final String username = "unc.serious.game@gmail.com";
        final String password = "3kncB9VRC4EJuvA#@xnJ";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));
            message.setSubject(titre);
            message.setText(contenu);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
}

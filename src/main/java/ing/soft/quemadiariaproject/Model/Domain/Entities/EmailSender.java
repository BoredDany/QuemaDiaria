package ing.soft.quemadiariaproject.Model.Domain.Entities;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private static final String HOST = "smtp.gmail.com";
    private static final String USERNAME = "quemadiaria5@gmail.com";
    private static final String APP_PASSWORD = "gubi brol dkxc lmws"; // Reemplaza con tu contraseña de aplicación

    public static void sendConfirmationEmail(String toEmail) {
        // Configurar propiedades
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", "587");

        // Crear una sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, APP_PASSWORD);
            }
        });

        try {
            // Crear un mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Confirmación de Registro");
            message.setText("Gracias por registrarte en nuestra aplicación. Tu código de confirmación es: " + "886645");

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo de confirmación enviado exitosamente.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

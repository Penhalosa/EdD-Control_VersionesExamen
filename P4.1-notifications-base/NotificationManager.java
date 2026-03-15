import java.util.logging.Logger;

public class NotificationManager {

    private static final Logger LOGGER = Logger.getLogger(NotificationManager.class.getName());

    public interface NotificationService {
        void send(String message, String recipient);
    }

    private class EmailService implements NotificationService {
        @Override
        public void send(String message, String recipient) {
            LOGGER.info("EMAIL → " + recipient);
            System.out.println("Email enviado a " + recipient + ": " + message);
        }
    }

    private class SMSService implements NotificationService {
        @Override
        public void send(String message, String recipient) {
            LOGGER.info("SMS → " + recipient);
            System.out.println("SMS enviado a " + recipient + ": " + message);
        }
    }

    private class PushService implements NotificationService {
        @Override
        public void send(String message, String recipient) {
            LOGGER.info("PUSH → " + recipient);
            System.out.println("Push enviado a " + recipient + ": " + message);
        }
    }

    private NotificationService getService(String type) {
        switch (type.toLowerCase()) {
            case "email": return new EmailService();
            case "sms": return new SMSService();
            case "push": return new PushService();
            default: throw new IllegalArgumentException("Tipo no válido: " + type);
        }
}

    public void send(String type, String message, String recipient) {
        NotificationService service = getService(type);
        service.send(message, recipient);
    }

    private void validate(String type, String message, String recipient) {
        if (type == null || type.isBlank())
            throw new IllegalArgumentException("Tipo vacío");

        if (message == null || message.isBlank())
            throw new IllegalArgumentException("Mensaje vacío");

        if (recipient == null || recipient.isBlank())
            throw new IllegalArgumentException("Destinatario vacío");

        if (type.equals("email") && !recipient.contains("@"))
            throw new IllegalArgumentException("Email inválido");

        if (type.equals("sms") && !recipient.matches("^\\+?[0-9]{7,15}$"))
            throw new IllegalArgumentException("Teléfono inválido");
    }

}
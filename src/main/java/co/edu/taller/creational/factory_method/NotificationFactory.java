package co.edu.taller.creational.factory_method;

public class NotificationFactory {
//    public interface Notifier {
//        String send(String recipient, String message);
//    }

    public enum Channel {EMAIL, SMS}

    public Notifier create(Channel channel) {
        // TODO: Return an implementation appropriate for the requested channel.
        if (channel == null) {
            throw new IllegalArgumentException("Channel cannot be null");
        }

        switch (channel) {
            case EMAIL:
                return new EmailNotifier();
            case SMS:
                return new SmsNotifier();
            default:
                throw new IllegalArgumentException("Unsupported channel: " + channel);
        }
    }
}
package co.edu.taller.creational.factory_method;

public class SmsNotifier implements Notifier {
    @Override
    public String send(String recipient, String message) {
        return "SMS:"+recipient+":"+message;
    }
}

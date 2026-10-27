package co.edu.taller.creational.factory_method;

public class EmailNotifier implements Notifier {
    @Override
    public String send(String recipient, String message) {
        return "EMAIL:"+recipient+":"+message;
    }
}

package designPatterns.creational.factoryMethod;

public class NotificationFactory {

    public static Notification createNotification(String type) {

        if (type == null) {
            return null;
        }

        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type");
        }
    }
}
/**
 * Simple Factory Example (Java)
 * Scenario
 *
 * We are building a Notification system that can send:
 *
 * Email
 *
 * SMS
 *
 * Push Notification
 */
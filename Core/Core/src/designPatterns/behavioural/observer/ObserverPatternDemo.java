package designPatterns.behavioural.observer;

public class ObserverPatternDemo {

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer channel1 = new NewsChannel("CNN");
        Observer channel2 = new NewsChannel("BBC");

        agency.registerObserver(channel1);
        agency.registerObserver(channel2);

        agency.setNews("Breaking News: Observer Pattern Explained!");
    }
}


/**
 * 6. When to Use Observer Pattern
 *
 * ✔ Event handling systems
 * ✔ Notification systems
 * ✔ Stock price updates
 * ✔ Messaging systems
 * ✔ Spring Boot application events
 */
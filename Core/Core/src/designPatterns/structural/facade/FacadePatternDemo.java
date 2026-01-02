package designPatterns.structural.facade;

public class FacadePatternDemo {
    public static void main(String[] args) {
        // Create subsystem objects
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();

        // Create the Facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector);

        // Use the simplified interface
        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}


/**
 * ✅ Key Points:
 *
 * The client interacts only with the HomeTheaterFacade.
 *
 * The subsystems remain hidden and are used internally by the facade.
 *
 * The complexity is abstracted into simple operations (watchMovie, endMovie).
 */
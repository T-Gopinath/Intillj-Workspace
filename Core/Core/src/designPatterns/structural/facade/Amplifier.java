package designPatterns.structural.facade;

// Amplifier subsystem
class Amplifier {
    public void on() {
        System.out.println("Amplifier is ON");
    }
    public void off() {
        System.out.println("Amplifier is OFF");
    }
}

// DVDPlayer subsystem
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }
    public void off() {
        System.out.println("DVD Player is OFF");
    }
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

// Projector subsystem
class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }
    public void off() {
        System.out.println("Projector is OFF");
    }
}

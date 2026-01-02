package designPatterns.behavioural.state;

public class StatePatternDemo {

    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        trafficLight.change();
        trafficLight.change();
        trafficLight.change();
        trafficLight.change();
    }
}

/**
 * 🧠 Interview Tip
 *
 * State Pattern vs Strategy Pattern
 *
 * State → behavior changes automatically based on state
 *
 * Strategy → behavior chosen explicitly by client
 */
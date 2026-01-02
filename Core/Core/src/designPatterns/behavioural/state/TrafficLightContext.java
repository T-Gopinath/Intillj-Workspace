package designPatterns.behavioural.state;

public class TrafficLightContext {

    private TrafficLightState state;

    public TrafficLightContext() {
        state = new RedLightState(); // initial state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.changeLight(this);
    }
}

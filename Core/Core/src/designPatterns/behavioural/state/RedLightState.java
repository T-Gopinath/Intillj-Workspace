package designPatterns.behavioural.state;

public class RedLightState implements TrafficLightState {

    @Override
    public void changeLight(TrafficLightContext context) {
        System.out.println("Red Light → Stop");
        context.setState(new GreenLightState());
    }
}

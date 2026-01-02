package designPatterns.behavioural.state;

public class GreenLightState implements TrafficLightState {

    @Override
    public void changeLight(TrafficLightContext context) {
        System.out.println("Green Light → Go");
        context.setState(new YellowLightState());
    }
}

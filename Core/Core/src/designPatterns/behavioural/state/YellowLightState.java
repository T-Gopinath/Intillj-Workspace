package designPatterns.behavioural.state;

public class YellowLightState implements TrafficLightState {

    @Override
    public void changeLight(TrafficLightContext context) {
        System.out.println("Yellow Light → Slow Down");
        context.setState(new RedLightState());
    }
}

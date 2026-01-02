package designPatterns.structural.flyweight;

// ConcreteFlyweight
public class Circle implements Shape {
    private String color;  // intrinsic state
    private int x;         // extrinsic state
    private int y;         // extrinsic state
    private int radius;    // extrinsic state

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setRadius(int radius) { this.radius = radius; }

    @Override
    public void draw() {
        System.out.println("Drawing " + color + " circle at (" + x + "," + y + ") with radius " + radius);
    }
}

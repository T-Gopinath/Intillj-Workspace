package designPatterns.structural.bridge;

// Implementer
interface Color {
    void applyColor();
}

// Concrete Implementer 1
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

// Concrete Implementer 2
class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

// Abstraction
abstract class Shape {
    protected Color color;  // Bridge: reference to implementer

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Refined Abstraction 1
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}

// Refined Abstraction 2
class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Rectangle with ");
        color.applyColor();
    }
}

// Client
public class BridgePatternExample {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        redCircle.draw();

        Shape blueRectangle = new Rectangle(new BlueColor());
        blueRectangle.draw();
    }
}

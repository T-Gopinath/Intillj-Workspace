package designPatterns.creational.prototype;

public class Rectangle implements Shape {
    private String color;

    public Rectangle(String color) {
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with color: " + color);
    }
}


package designPatterns.creational.prototype;

public class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Circle(this.color); // shallow copy
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with color: " + color);
    }
}

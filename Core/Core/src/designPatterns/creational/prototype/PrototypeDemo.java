package designPatterns.creational.prototype;

public class PrototypeDemo {
    public static void main(String[] args) {

        Shape shape1 = ShapeRegistry.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = ShapeRegistry.getShape("RECTANGLE");
        shape2.draw();
    }
}

/**
 * Key Idea
 *
 * Create new objects by cloning existing ones
 *
 * When to Use
 *
 * Creating objects is expensive (DB calls, network calls, heavy initialization)
 *
 * You need runtime object creation
 *
 * You want to hide object creation logic
 */
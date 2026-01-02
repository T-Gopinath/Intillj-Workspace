package designPatterns.structural.flyweight;

public class FlyweightPatternDemo {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(5);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int)(Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int)(Math.random() * 100);
    }

    private static int getRandomY() {
        return (int)(Math.random() * 100);
    }
}


/**
 * Key Points
 *
 * Intrinsic state → shared (e.g., color).
 *
 * Extrinsic state → supplied by client (e.g., position, size).
 *
 * Flyweight pattern reduces memory when many similar objects are needed.
 *
 * Typically used in text editors (characters), graphical applications, game development, etc.
 */
package designPatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    private static final Map<String, Shape> shapes = new HashMap<>();

    static {
        shapes.put("CIRCLE", new Circle("Red"));
        shapes.put("RECTANGLE", new Rectangle("Blue"));
    }

    public static Shape getShape(String type) {
        return shapes.get(type).clone();
    }
}

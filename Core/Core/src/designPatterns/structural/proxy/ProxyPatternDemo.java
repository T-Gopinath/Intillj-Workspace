package designPatterns.structural.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded from disk only when display() is called
        image1.display(); 
        System.out.println("");
        image1.display(); // Loaded once, then reused

        System.out.println("");
        image2.display();
    }
}

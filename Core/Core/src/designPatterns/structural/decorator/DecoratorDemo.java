package designPatterns.structural.decorator;

// Step 1: Component
interface Text {
    String format();
}

// Step 2: ConcreteComponent
class PlainText implements Text {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String format() {
        return text;
    }
}

// Step 3: Decorator
abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String format() {
        return decoratedText.format();
    }
}

// Step 4: ConcreteDecorator 1
class BoldText extends TextDecorator {

    public BoldText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String format() {
        return "<b>" + super.format() + "</b>";
    }
}

// Step 4: ConcreteDecorator 2
class ItalicText extends TextDecorator {

    public ItalicText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String format() {
        return "<i>" + super.format() + "</i>";
    }
}

// Step 5: Usage
public class DecoratorDemo {
    public static void main(String[] args) {
        Text myText = new PlainText("Hello, World!");

        // Decorate with Bold
        Text boldText = new BoldText(myText);

        // Decorate with Italic on top of Bold
        Text italicBoldText = new ItalicText(boldText);

        System.out.println(myText.format());          // Output: Hello, World!
        System.out.println(boldText.format());        // Output: <b>Hello, World!</b>
        System.out.println(italicBoldText.format());  // Output: <i><b>Hello, World!</b></i>
    }
}


/**
 * ✅ Benefits
 *
 * Adds responsibilities dynamically, without modifying existing code.
 *
 * Supports open/closed principle.
 *
 * Can combine multiple decorators flexibly.
 */
package designPatterns.behavioural.memento;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setContent("Version 1");
        history.save(editor.save());

        editor.setContent("Version 2");
        history.save(editor.save());

        editor.setContent("Version 3");

        editor.restore(history.undo());
        System.out.println(editor.getContent()); // Version 2
    }
}

/**
 * 🌐 Real-World Examples
 *
 * Text editors (Undo / Redo)
 *
 * IDE history (Eclipse, IntelliJ)
 *
 * Database transactions
 *
 * Game save checkpoints
 */
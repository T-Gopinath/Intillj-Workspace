package designPatterns.behavioural.template;

abstract class DataProcessor {

    // Template method
    public final void process() {
        readData();
        processData();
        saveData();
        hook(); // optional step
    }

    protected abstract void readData();
    protected abstract void processData();

    protected void saveData() {
        System.out.println("Saving data to database");
    }

    // Hook method
    protected void hook() {
        // optional override
    }
}





//✅ Thread-Safe Singleton (Double-Checked Locking)
 public class SingletonEamaple {

    // volatile ensures visibility and prevents instruction reordering
    private static volatile SingletonEamaple instance;

    // private constructor prevents object creation from outside
    private SingletonEamaple() {
        // optional: protect against reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

     static SingletonEamaple getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (SingletonEamaple.class) {
                if (instance == null) {  // Second check (with lock)
                    instance = new SingletonEamaple();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance: " + this.hashCode());
    }
}


 class Main2 {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            SingletonEamaple singleton = SingletonEamaple.getInstance();
            singleton.showMessage();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

/*
    Expected Output (same hashCode for all threads)

        Singleton instance: 12345678
        Singleton instance: 12345678
        Singleton instance: 12345678


        ✅ Why Double-Checked Locking?

        Lazy initialization
        Thread-safe
        Locking happens only on first call
        volatile prevents JVM instruction reordering (critical for DCL)


 */
/*
        ✅ Producer–Consumer using wait/notify (Classic Bounded Buffer)

 */
class Buffer {
    private final int[] arr;
    private int size;
    private int in;
    private int out;
    private int count;

    public Buffer(int size) {
        this.size = size;
        arr = new int[size];
        in = out = count = 0;
    }

    // Producer puts an item
    public synchronized void put(int item) throws InterruptedException {
        while (count == size) {        // Buffer full
            wait();
        }

        arr[in] = item;
        in = (in + 1) % size;
        count++;

        System.out.println("Produced: " + item);

        notifyAll();                   // Notify waiting consumer
    }

    // Consumer takes an item
    public synchronized int take() throws InterruptedException {
        while (count == 0) {           // Buffer empty
            wait();
        }

        int item = arr[out];
        out = (out + 1) % size;
        count--;

        System.out.println("Consumed: " + item);

        notifyAll();                   // Notify waiting producer
        return item;
    }
}


class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                buffer.put(value++);
                Thread.sleep(300);     // slow down for demo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.take();
                Thread.sleep(500);     // slow down for demo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);       // bounded capacity = 5

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();
    }
}


/*
        ✔️ Key Concepts Used

        synchronized methods to protect shared buffer.

        wait() to suspend thread when:

        Producer: buffer full

        Consumer: buffer empty

        notifyAll() to wake up waiting threads.

        Circular buffer indexing using (index + 1) % size.
 */

/*
            ✅ Dining Philosophers – Deadlock-Free (Pick Lower Fork First)
    ✔ Key idea

    A philosopher with forks left and right always picks:

    int first = Math.min(left, right);
    int second = Math.max(left, right);


    This enforces a global order → no circular wait → no deadlock
     */
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public static void main(String[] args) throws InterruptedException {
        int n = 5; // number of philosophers
        Philosopher[] philosophers = new Philosopher[n];
        ReentrantLock[] forks = new ReentrantLock[n];

        // create forks
        for (int i = 0; i < n; i++) {
            forks[i] = new ReentrantLock();
        }

        // create philosophers
        for (int i = 0; i < n; i++) {
            philosophers[i] = new Philosopher(i, forks);
            new Thread(philosophers[i], "Philosopher-" + i).start();
        }
    }
}

class Philosopher implements Runnable {

    private final int id;
    private final ReentrantLock[] forks;

    Philosopher(int id, ReentrantLock[] forks) {
        this.id = id;
        this.forks = forks;
    }

    @Override
    public void run() {
        int left = id;
        int right = (id + 1) % forks.length;

        // Always pick lower-numbered fork first
        int first = Math.min(left, right);
        int second = Math.max(left, right);

        while (true) {
            think();

            // Pick up first fork
            forks[first].lock();
            System.out.println("Philosopher " + id + " picked up fork " + first);

            // Pick up second fork
            forks[second].lock();
            System.out.println("Philosopher " + id + " picked up fork " + second);

            eat();

            // Put down forks
            forks[second].unlock();
            forks[first].unlock();

            System.out.println("Philosopher " + id + " put down forks and is thinking again.");
        }
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking.");
        sleep(500);
    }

    private void eat() {
        System.out.println("Philosopher " + id + " is eating.");
        sleep(500);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


/*
        ✅ Why this avoids deadlock?

        Deadlock requires 4 conditions. The one we break is circular wait.

        If all philosophers follow the rule:

        👉 Always pick the lower-numbered fork first

        …then:

        No circular waiting chain can form

        A strict global order exists: 0 < 1 < 2 < ...

        Thus, deadlock is impossible.

        Want a version with:

        ✔ Semaphore instead of ReentrantLock
        ✔ wait/notify
        ✔ dining philosophers with "limit 4 at table" trick
        ✔ random think/eat time
 */


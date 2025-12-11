//Implement stack using queues Make LIFO using two FIFO queues.
import java.util.*;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        // Step 1: Add new element to q2
        q2.add(x);

        // Step 2: Move everything from q1 → q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 & q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();  // O(1)
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

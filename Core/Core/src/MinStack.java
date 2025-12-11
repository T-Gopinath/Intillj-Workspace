/*
        Sure! Here’s a Java implementation of a Min Stack that supports push, pop, top, and getMin operations all in O(1) time complexity using an auxiliary stack:

        ✅ Explanation:

        Two stacks approach:

        stack stores all elements.

        minStack stores the minimum elements.

        On push:

        Always push to the main stack.

        Push to minStack if the new element is ≤ current minimum.

        On pop:

        Pop from stack.

        If popped element equals minStack’s top, pop it from minStack too.

        getMin always returns minStack.peek(), ensuring O(1) access to the minimum element.

        This method guarantees that all operations, including getMin, run in constant time.

        If you want, I can also show a more space-efficient version that uses only one stack while still keeping O(1) getMin.

 */

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;      // main stack
    private Stack<Integer> minStack;   // stack to keep track of minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // push to minStack if it's empty or x is smaller than or equal to current min
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        int removed = stack.pop();
        // if the removed element is the minimum, pop it from minStack too
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new RuntimeException("Stack is empty");
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Min: " + minStack.getMin()); // 3
        minStack.push(2);
        minStack.push(1);
        System.out.println("Min: " + minStack.getMin()); // 1
        minStack.pop();
        System.out.println("Min: " + minStack.getMin()); // 2
        System.out.println("Top: " + minStack.top());    // 2
    }
}

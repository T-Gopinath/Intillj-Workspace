//Fibonacci Numbers (Iterative Method)
    /*
        fib(0) = 0
    fib(1) = 1
    fib(n) = fib(n-1) + fib(n-2)
    */
public class FibonacciIterative {

    public static int fibonacci(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;   // first two Fibonacci numbers

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));   // Output: 55
    }
}



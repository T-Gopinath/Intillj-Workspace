// Rotate array by k (Juggling)
//Rotate array to right by k positions using gcd method.

public class Juggling {

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Rotate Right by k using Juggling Algorithm
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;           // reduce extra rotations
        if (k == 0) return;  // no rotation

        int g = gcd(n, k);   // number of cycles

        for (int i = 0; i < g; i++) {
            int temp = arr[i];
            int j = i;

            while (true) {
                int next = (j + k) % n;

                if (next == i)
                    break;

                arr[j] = arr[next];
                j = next;
            }
            arr[j] = temp;
        }
    }
}

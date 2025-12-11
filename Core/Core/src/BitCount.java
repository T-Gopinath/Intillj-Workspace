
/*
    Count set bits — Brian Kernighan’s algorithm
    Brian Kernighan’s trick repeatedly clears the lowest set bit (turns the rightmost 1 to 0) using n = n & (n-1).
    Each iteration removes one 1, so the loop runs exactly as many times as there are set bits.
    Complexity: O(k) where k = number of 1-bits (not number of bits overall). Space O(1).
    How it works (quick example):
    n = 0b10110 (22)
    n & (n-1) → 0b10110 & 0b10101 = 0b10100 (clears the lowest 1)
    repeat until n == 0 — number of iterations = number of 1s (here 3).
 */
public class BitCount {
    // Counts 1-bits in 32-bit two's-complement representation
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    //If you want the count for an unsigned 32-bit value passed as a long:
    public static int countSetBitsUnsigned(long value) {
        // treat value as unsigned 32-bit in lower bits
        int n = (int)(value & 0xFFFFFFFFL);
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }


    // Example / quick test
    public static void main(String[] args) {
        System.out.println(countSetBits(0));      // 0
        System.out.println(countSetBits(1));      // 1
        System.out.println(countSetBits(22));     // 3  (10110)
        System.out.println(countSetBits(-1));     // 32 (all ones in 32-bit two's complement)
        // Note: For Java you can also use Integer.bitCount(n) which is highly optimized.
    }
}
    /*
        ✅ Power of Two Check (Bit Trick)

        A number n is a power of two if and only if:

        n > 0

        n & (n - 1) == 0

        Because a power-of-two number has exactly one set bit, and subtracting 1 flips all lower bits.
        Example: 8 = 1000, 7 = 0111, 1000 & 0111 = 0.
     */
   /* public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
*/

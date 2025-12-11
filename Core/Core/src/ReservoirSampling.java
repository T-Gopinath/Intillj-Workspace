
/*
    ✅ Reservoir Sampling in Java (k items)
    Idea

    Maintain an array reservoir[] of size k.

    Fill it with the first k items of the stream.

    For every new item at index i (0-based):

    Generate a random index j between 0 and i.

    If j < k, replace reservoir[j] with the new item.

    Ensures each element has equal probability k/n.

*/

import java.util.Random;

public class ReservoirSampling {

    // Function to perform reservoir sampling for k items
    public static int[] reservoirSample(int[] stream, int k) {
        int n = stream.length;
        int[] reservoir = new int[k];
        Random rand = new Random();

        // Step 1: Fill the first k items
        for (int i = 0; i < k; i++) {
            reservoir[i] = stream[i];
        }

        // Step 2: Process the rest of the stream
        for (int i = k; i < n; i++) {
            int j = rand.nextInt(i + 1);   // random index from 0 to i
            if (j < k) {
                reservoir[j] = stream[i];
            }
        }

        return reservoir;
    }

    public static void main(String[] args) {
        int[] stream = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int k = 3;

        int[] sample = reservoirSample(stream, k);

        System.out.print("Random Sample: ");
        for (int x : sample) {
            System.out.print(x + " ");
        }
    }
}


/*
    📌 Sample Output (Random Every Run)
    Random Sample: 20 70 50


    Each item in the stream has an equal chance of being included.

    🧠 Notes

    Works even when stream size is unknown or extremely large.

    Uses O(k) space.

    Time complexity O(n).
 */
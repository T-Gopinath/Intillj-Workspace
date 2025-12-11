/*
    Here is a clear and clean Java program to find the K-th smallest element using QuickSelect (average time: O(n)):
    ✅ Java Program — QuickSelect (Kth Smallest Element)
        ✅ Example
       Input array:
        [7, 10, 4, 3, 20, 15]
        k = 3
        Output:
        3rd smallest element is: 7
 */

import java.util.*;

public class QuickSelect {

    // Function to partition the array
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];     // choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // pivot index
    }

    // QuickSelect function
    public static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);

            // If pivot is the kth smallest
            if (pivotIndex == k - 1) {
                return arr[pivotIndex];
            }

            // If pivot index is greater, search left
            if (pivotIndex > k - 1) {
                return quickSelect(arr, low, pivotIndex - 1, k);
            }

            // Else search right
            return quickSelect(arr, pivotIndex + 1, high, k);
        }

        return -1; // should not reach here for valid k
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int result = quickSelect(arr, 0, arr.length - 1, k);
        System.out.println(k + "rd smallest element is: " + result);
    }
}

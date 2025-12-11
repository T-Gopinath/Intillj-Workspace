/*
    Binary Search (Iterative)
    Works on a sorted array (ascending order).
        🧠 Logic

    Start with left = 0, right = n-1.

    Find mid.

    Compare:

    If arr[mid] == target → return.

    If target > arr[mid] → search right.

    If target < arr[mid] → search left.

    Repeat while left <= right

    📌 Time & Space

    Time: O(log n)

    Space: O(1)
*/
public class BinarySearchIterative {

    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;  // avoids overflow

            if (arr[mid] == target) {
                return mid;      // found
            }
            else if (arr[mid] < target) {
                left = mid + 1;  // search right half
            }
            else {
                right = mid - 1; // search left half
            }
        }

        return -1;  // not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72};
        System.out.println(binarySearch(arr, 23)); // Output: 5
    }
}
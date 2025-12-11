
/*
    Kth largest (heap) Find kth largest using a min-heap of size k
    Algorithm

    Create a min-heap of size k.

    Iterate through the array:

    Add the current element to the heap.

    If heap size exceeds k, remove the smallest element (heap root).

    After processing all elements, the root of the min-heap is the kth largest element.

    Why min-heap?

    Because we want the kth largest element, we maintain the k largest elements in the heap.

    The smallest among these k elements (the heap root) will be the kth largest overall.
    Example

    Input: nums = [3,2,1,5,6,4], k = 2
    Process using a min-heap of size 2:

    Add 3 → heap: [3]

    Add 2 → heap: [2,3]

    Add 1 → heap: [2,3] (remove 1, size > 2)

    Add 5 → heap: [3,5] (remove 2)

    Add 6 → heap: [5,6] (remove 3)

    Add 4 → heap: [5,6] (remove 4)

    Heap root: 5 → 2nd largest element.


    ✅ Time Complexity:

    O(n log k) → for n elements, maintaining heap of size k.

    ✅ Space Complexity:

    O(k) → size of the heap.
 */
import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        // Min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest to keep heap size k
            }
        }

        // The root of the heap is the kth largest
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth largest element is: " + findKthLargest(nums, k));
    }
}

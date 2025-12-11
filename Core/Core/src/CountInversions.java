
/*

    An inversion is any pair (i, j) such that:
     i < j  AND  arr[i] > arr[j]
    We count these during the merge step.

    ✅ Java Program: Count Inversions Using Modified Merge Sort
 */

public class CountInversions {

    public static long countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);

            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // left subarray pointer
        int j = mid + 1;  // right subarray pointer
        int k = left;     // temp array pointer
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);  // all remaining elements in left are inversions
            }
        }

        // copy remaining elements
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // copy back to original
        for (i = left; i <= right; i++) arr[i] = temp[i];

        return invCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        long count = countInversions(arr);
        System.out.println("Inversion Count = " + count);
    }
}


/*
✔️ Example

For input:

2 4 1 3 5


Inversions:

(2,1), (4,1), (4,3)
Total = 3


Program prints:

Inversion Count = 3
 */
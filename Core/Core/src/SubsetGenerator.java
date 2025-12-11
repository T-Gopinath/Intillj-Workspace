/*
    Subset generation (backtracking)
    Generate all subsets (power set).

    ✅ How it works:

    Start with an empty subset.

    At each step, either include or exclude the current element (backtracking explores all combinations).

    Add the current subset to the result.

    Recursively explore the next elements.

    Backtrack by removing the last element before exploring the next possibility.

    Example output for {1, 2, 3}:

    []
    [1]
    [1, 2]
    [1, 2, 3]
    [1, 3]
    [2]
    [2, 3]
    [3]
 */

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {

    // Function to generate all subsets
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Explore further elements to add
        for (int i = index; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);
            // Recurse
            backtrack(nums, i + 1, current, result);
            // Backtrack: remove last element
            current.remove(current.size() - 1);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}


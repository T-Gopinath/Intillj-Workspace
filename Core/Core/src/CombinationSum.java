/*
        Combination Sum (unique combinations)
        Find combinations summing to target using candidates

        Sure! You want a Java program to find all unique combinations of numbers from a given array (candidates) that sum up to a target value. Each number in candidates can be used multiple times in a combination. This is a classic backtracking problem. Here's a clean implementation:

        ✅ How it works:
        Sort candidates (optional but helps pruning).
         Start backtracking from the first index.

        Add a number to the current combination and recursively try to reach the target.

        If target becomes 0 → add combination to the result.

        Remove last element (backtrack) and try next candidate.

        Example Output:

        For candidates = [2,3,6,7] and target = 7:

        [2, 2, 3]
        [7]

 */


import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Optional: helps to prune branches early
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start,
                                  List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            // Found a valid combination
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                // No need to continue as the array is sorted
                break;
            }

            combination.add(candidates[i]);
            // `i` instead of `i+1` allows reuse of the same element
            backtrack(candidates, target - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println("Combinations summing to " + target + ":");
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}

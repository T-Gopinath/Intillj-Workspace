
/*
    ✅ Edit Distance (Levenshtein Distance) – Java Program (DP)

    Operations allowed:

    Insert

    Delete

    Replace

    Time Complexity: O(m × n)
    Space Complexity: O(m × n)
 */
public class EditDistance {

    public static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete all characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert all characters
        }

        // DP computation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // no operation
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("Edit Distance: " + minDistance(s1, s2));
    }
}



/*
    ✔️ Example

    Input:
    s1 = "horse"
    s2 = "ros"

    Output:

    Edit Distance: 3

    ✔️ Explanation of DP State

    dp[i][j] = minimum edit distance between
    first i characters of s1 and first j characters of s2.

    Transition:

    If characters match → dp[i][j] = dp[i-1][j-1]

    Else

    dp[i][j] = 1 + min(
        dp[i][j-1],   // insert
        dp[i-1][j],   // delete
        dp[i-1][j-1]  // replace
)
 */
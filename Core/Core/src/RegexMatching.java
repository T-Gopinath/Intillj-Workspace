
/*
    Here is a clean and efficient Java program for Regular Expression Matching supporting . (matches any single character) and * (matches zero or more of the preceding character).
    This uses Dynamic Programming (DP) — the standard optimal approach.

    ✅ Regular Expression Matching – Java (DP Solution)
    Supported

    . → matches any single character

    * → matches zero or more of the preceding character
 */
public class RegexMatching {

    public static boolean isMatch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();

        // dp[i][j] = does text[0..i-1] match pattern[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty text and empty pattern MATCH
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c* that can match empty string
        for (int j = 2; j <= n; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // Case 1: Characters match OR pattern has '.'
                if (pattern.charAt(j - 1) == text.charAt(i - 1) ||
                        pattern.charAt(j - 1) == '.') {

                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: Pattern contains '*'
                else if (pattern.charAt(j - 1) == '*') {

                    // Zero occurrence of previous char in pattern
                    dp[i][j] = dp[i][j - 2];

                    // One or more occurrences
                    if (pattern.charAt(j - 2) == text.charAt(i - 1) ||
                            pattern.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));        // false
        System.out.println(isMatch("aa", "a*"));       // true
        System.out.println(isMatch("ab", ".*"));       // true
        System.out.println(isMatch("aab", "c*a*b"));   // true
        System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
    }
}


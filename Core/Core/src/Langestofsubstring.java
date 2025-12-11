/*✅ 1. Vertical Scan (Most Common Approach)

We compare characters of each string at the same index.

Time: O(N·M)

N = number of strings, M = length of smallest string

✅ Java Code (Vertical Scan)
*/

public class Langestofsubstring {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}




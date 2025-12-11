/**
     Word search in grid (DFS backtracking)
     Check if word exists in 2D board.
     ✅ How it works:

     Loop through each cell of the board.
     Start DFS from cells that match the first character of the word.
     Recursively explore all four directions.
     Mark cells as visited by temporarily replacing the character (#) to avoid revisiting.
     Backtrack after DFS by restoring the original character.
     Return true if the entire word is found, false otherwise.
 */

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base case: all characters matched
        if (index == word.length()) return true;

        // Check boundaries and character match
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited by temporarily changing its value
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions: up, down, left, right
        boolean found = dfs(board, word, row + 1, col, index + 1)
                || dfs(board, word, row - 1, col, index + 1)
                || dfs(board, word, row, col + 1, index + 1)
                || dfs(board, word, row, col - 1, index + 1);

        // Restore original value (backtrack)
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word1 = "ABCCED"; // true
        String word2 = "SEE";    // true
        String word3 = "ABCB";   // false

        System.out.println(exist(board, word1)); // true
        System.out.println(exist(board, word2)); // true
        System.out.println(exist(board, word3)); // false
    }
}

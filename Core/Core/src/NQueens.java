/*
Here is a clean and complete Java program for the N-Queens problem using backtracking.
It prints all valid board configurations for a given N.

✅ Java Program: N-Queens (Backtracking)
 */
public class NQueens {

    // Main function
    public static void main(String[] args) {
        int n = 4; // Change N here
        solveNQueens(n);
    }

    // Wrapper to solve N-Queens
    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize board with dots
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0, n);
    }

    // Backtracking function
    public static void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            printBoard(board);
            System.out.println();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    // Check if placing a queen is safe
    public static boolean isSafe(char[][] board, int row, int col, int n) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // Print board
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

/*
        ✅ Output Example for N = 4
        . Q . .
        . . . Q
        Q . . .
        . . Q .

        . . Q .
        Q . . .
        . . . Q
        . Q . .

        ✔️ Features

        Uses standard backtracking

        Ensures no column, no left diagonal, no right diagonal has another queen

        Prints all valid solutions

        Easy to modify (set n in main)
 */
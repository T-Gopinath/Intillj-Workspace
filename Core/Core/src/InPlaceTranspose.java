/*
    ✅ Matrix Transpose (In-Place) — Java Program
    Logic
    For a square matrix, transpose can be done by:
    Swapping elements at (i, j) with (j, i)
    Only for j > i (upper triangle), to avoid double swapping.
 */

public class InPlaceTranspose {

    public static void transpose(int[][] matrix) {
        int n = matrix.length;

        // In-place transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        transpose(matrix);

        System.out.println("\nTransposed Matrix:");
        printMatrix(matrix);
    }
}


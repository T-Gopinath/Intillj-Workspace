/*
    ✅ Java Program: Spiral Matrix Traversal (Clockwise)

        For the sample 4×4 matrix, output will be:
            Spiral Order: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]

 */

import java.util.*;

public class SpiralMatrixTraversal {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 1️⃣ Traverse Left → Right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // 2️⃣ Traverse Top → Bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 3️⃣ Traverse Right → Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 4️⃣ Traverse Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };

        List<Integer> result = spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
    }
}




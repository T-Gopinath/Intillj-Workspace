

/*
        Count islands (DFS/BFS)
        Count connected components of 1s in grid.

        ✅ Explanation:

Treat each 1 in the grid as part of a potential island.

For each unvisited 1, start a DFS/BFS to mark all connected 1s.

Each DFS/BFS invocation represents one island → increment the count.

You can consider 4 directions (N, S, E, W) or 8 directions (including diagonals) depending on the problem. Here, I used 8-direction connectivity.

 */

//DFS Approach

import java.util.LinkedList;
import java.util.Queue;

public class CountIslandsDFS {
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    // DFS to mark all connected 1s
    private static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;

        for (int k = 0; k < 8; k++) {
            int newRow = row + rowDir[k];
            int newCol = col + colDir[k];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                    && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(grid, newRow, newCol, visited);
            }
        }
    }

    public static int countIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands (DFS): " + countIslands(grid));
    }
}

//BFS Approach



 class CountIslandsBFS {
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static void bfs(int[][] grid, int row, int col, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int k = 0; k < 8; k++) {
                int newRow = r + rowDir[k];
                int newCol = c + colDir[k];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    public static int countIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands (BFS): " + countIslands(grid));
    }
}


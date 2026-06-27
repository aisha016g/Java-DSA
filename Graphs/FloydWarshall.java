import java.util.*;

class Solution {
    public void shortest_dist(int[][] matrix) {
        int n = matrix.length;

        // 1. Initialize: Change -1 (no edge) to a large value (infinity)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) (1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        // 2. Floyd-Warshall Core Logic (Fixed the indices here)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // 3. Post-process: Convert infinity back to -1 for unreachable nodes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= (int) (1e9)) { // >= handles slight overflows safely
                    matrix[i][j] = -1;
                }
            }
        }
    }
}

public class FloydWarshall {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample adjacency matrix (-1 represents no direct edge)
        int[][] matrix = {
            {0, 3, -1, 7},
            {8, 0, 2, -1},
            {5, -1, 0, 1},
            {2, -1, -1, 0}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        solver.shortest_dist(matrix);

        System.out.println("\nShortest Path Matrix (All-Pairs Shortest Path):");
        printMatrix(matrix);
    }

    // A much simpler print method using standard print and tabs
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println(); // Moves to the next line after a row is done
        }
    }
}
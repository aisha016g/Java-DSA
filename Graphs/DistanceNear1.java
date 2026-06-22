import java.util.*;

class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {

    public int[][] nearest(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            for (int t = 0; t < 4; t++) {

                int nr = curr.i + delRow[t];
                int nc = curr.j + delCol[t];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    dist[nr][nc] = dist[curr.i][curr.j] + 1;

                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return dist;
    }
}

public class DistanceNear1 {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 0, 0}
        };
        Solution obj = new Solution();
        int[][] ans = obj.nearest(matrix);

        System.out.println("Distance Matrix:");

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
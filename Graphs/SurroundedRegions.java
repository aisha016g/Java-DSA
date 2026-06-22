import java.util.*;

class Solution {
    public char[][] solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        // Top boundary - row=0 fix col changes
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                dfs(board, 0, j, vis);
            }
        }

        // Bottom boundary - row = n-1 fixed col changes
        for (int j = 0; j < m; j++) {
            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                dfs(board, n - 1, j, vis);
            }
        }

        // Left boundary - col=0 fix row changes
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(board, i, 0, vis);
            }
        }

        // Right boundary - col = m-1 fixed row changes
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                dfs(board, i, m - 1, vis);
            }
        }

        // Convert surrounded O's to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

    public void dfs(char[][] board, int r, int c, boolean[][] vis) {

        int n = board.length;
        int m = board[0].length;

        vis[r][c] = true;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {

            int nr = r + delRow[i];
            int nc = c + delCol[i];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                !vis[nr][nc] &&
                board[nr][nc] == 'O')
                 {

                dfs(board, nr, nc, vis);
            }
        }
    }
}

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        Solution obj = new Solution();
        char[][] ans = obj.solve(board);

        System.out.println("Final Board:");

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
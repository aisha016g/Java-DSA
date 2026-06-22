class Solution{
    public int numEnclaves(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int enclaves = 0;
        boolean[][] vis = new boolean[n][m];

        // top row = 0 fix col change
        for(int i = 0;i< m;i++ ){
            if(grid[0][i] == 1 && !vis[0][i]){
                dfs(grid,0,i,vis);
            }
        }

        //bottom - row = n-1 fix col change
        for(int i = 0 ;i< m ;i++ ){
            if(grid[n-1][i] == 1 && !vis[n-1][i]){
                dfs(grid,n-1,i,vis);
            }
        }

        //left - col = 0 fix row changes
        for(int i =0;i<n;i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(grid,i,0,vis);
            }
        }

        // right - col = m-1 fix row change
        for(int i=0;i<n;i++){
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                dfs(grid,i,m-1,vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid,int r,int c,boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        vis[r][c] = true;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {

            int nr = r + delRow[i];
            int nc = c + delCol[i];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                !vis[nr][nc] &&
                grid[nr][nc] == 1)
                 {

                dfs(grid, nr, nc, vis);
            }
        }
    }
}

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        Solution obj = new Solution();
        int ans = obj.numEnclaves(grid);
        System.out.println("Number of Enclaves: " + ans);
    }
}
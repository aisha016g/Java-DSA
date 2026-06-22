import java.util.*;

class Solution{ 

    public int countDistinctIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j =0;j< m;j++){
                if(grid[i][j] == 1 && !vis[i][j])
                    {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(grid, i, j, vis, i, j, shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    public void dfs(int[][] grid,int r,int c,boolean[][]vis,int  baseRow,int baseCol,ArrayList<String>shape)
    {
        vis[r][c] = true;
        shape.add((r - baseRow) + " " + (c - baseCol));
        
        int n = grid.length;
        int m = grid[0].length;


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

                dfs(grid, nr, nc, vis,baseRow,baseCol,shape);
            }
        }

    }
}

public class DistinctIsland {

    public static void main(String[] args) {

        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0}
        };

        Solution obj = new Solution();

        int ans = obj.countDistinctIslands(grid);

        System.out.println("Number of Distinct Islands: " + ans);
    }

}

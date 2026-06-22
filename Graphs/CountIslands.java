import java.util.*;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public void bfs(int i, int j, char[][] grid,boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        vis[i][j] = true;

        Pair p = new Pair(i,j);
        q.offer(p);

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;

            //up
            if(r-1>=0 && grid[r-1][c] == '1' && vis[r-1][c] == false)
            {
                vis[r-1][c] = true;
                q.offer(new Pair(r-1,c));
            }
            
            //down
            if(r+1<n && grid[r+1][c] == '1' && vis[r+1][c] == false)
            {
                vis[r+1][c] = true;
                q.offer(new Pair(r+1,c));
            }

            //right
            if(c+1<m && grid[r][c+1] == '1' && vis[r][c+1] == false)
            {
                vis[r][c+1] = true;
                q.offer(new Pair(r,c+1));
            }
            
            //left
            if(c-1>=0 && grid[r][c-1] == '1' && vis[r][c-1] == false)
            {
                vis[r][c-1] = true;
                q.offer(new Pair(r,c-1));
            }
        }

    }

    public int numIslands(char[][] grid) {
        int islands = 0 ;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ;i < n ; i++){
            for(int j = 0; j < m ;j++){
                if(vis[i][j] == false && grid[i][j] == '1' ){
                    islands++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return islands;
    }
}

public class CountIslands {
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        Solution obj = new Solution();

        System.out.println(obj.numIslands(grid));
    }
}
import java.util.*;
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if(originalColor == color) 
            return image;

        dfs(image,sr,sc,originalColor,color);
        return image;
    }

    public void dfs(int[][] image,int nr,int nc,int originalColor,int color) {
        int n = image.length;
        int m = image[0].length;

        int[] delRow = {-1,1,0,0};
        int[] delCol = {0,0,-1,1};

        image[nr][nc] = color;

        for(int i =0;i<delRow.length ; i++){
            int newRow = nr + delRow[i];
            int newCol = nc + delCol[i];
            if( newRow>=0 && newRow<n && newCol>=0 && newCol<m){

                if(image[newRow][newCol] == originalColor){
                    
                    dfs(image, newRow, newCol, originalColor, color);
                }
            }
        }
    }
}
public class FloodFill {
    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        Solution obj = new Solution();

        int[][] ans = obj.floodFill(image, sr, sc, color);

        for (int[] row : ans) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


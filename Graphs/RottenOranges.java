import java.util.*;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution{
    public int rotten(int[][] oranges){
        int freshCnt = 0;
        int n = oranges.length;
        int m = oranges[0].length;

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(oranges[i][j] == 1)
                    freshCnt++;

                if(oranges[i][j] == 2)
                    q.offer(new Pair(i,j));
            }
        }
        if(freshCnt == 0)
            return 0;
        
        int[] nr = {-1,1,0,0};
        int[] nc = {0,0,-1,1};
        int minutes = 0;
        int rottedFresh = 0;

        while(!q.isEmpty()){
            int size = q.size();
            boolean infected = false;
            for(int i = 0;i < size ; i++)
            {
                Pair curr = q.poll();
                for(int j= 0 ; j< nr.length;j++)
                {
                int newRow = curr.row + nr[j];
                int newCol = curr.col + nc[j];
                if(newRow >= 0 && newRow <n && newCol>=0 && newCol<m){
                    if(oranges[newRow][newCol] == 1){
                        oranges[newRow][newCol] = 2;
                        q.offer(new Pair(newRow,newCol));
                        rottedFresh++;
                        infected = true;
                    }
                }
            }
        }
        if(infected)
        minutes++;
        }
        if(rottedFresh == freshCnt)
            return minutes;
        return -1;
    }

}

public class RottenOranges {
    public static void main(String[] args) {
        int[][] oranges = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        Solution sol = new Solution();

        int result = sol.rotten(oranges);

        System.out.println("Minutes required: " + result);
    }
}
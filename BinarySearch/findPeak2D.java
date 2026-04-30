import java.util.Scanner;

public class findPeak2D{
    public int[] brute(int[][] arr, int n, int m){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int curr = arr[i][j];

            int left = (j-1>=0)? arr[i][j-1] : -1;
            int right = (j+1<m)? arr[i][j+1] : -1;
            int up = (i-1>=0)? arr[i-1][j] : -1;
            int down = (i+1<n)? arr[i+1][j] : -1;

            if(curr>left && curr>right && curr>up && curr>down)
                return new int[]{i,j};
        }
    }
    return new int[]{-1,-1};
}

    int maxEle(int[][] arr,int n,int m,int col){
        int maxVal=-1,maxIdx=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i][col]>maxVal)
            {
                maxVal=arr[i][col];
                maxIdx=i;
            }
        }
        return maxIdx;
    }
    public int[] optimal(int[][] arr,int n,int m){
        int low=0,high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int maxRowIdx=maxEle(arr,n,m,mid);
            int left=mid-1>=0? arr[maxRowIdx][mid-1]:-1;
            int right=mid+1<m ? arr[maxRowIdx][mid+1]:-1;
            if(arr[maxRowIdx][mid]>left && arr[maxRowIdx][mid]>right)
                return new int[] {maxRowIdx,mid};
            else if(arr[maxRowIdx][mid]<left)
                high=mid-1;
            else
                low=mid+1;
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j]=sc.nextInt();
        }
       
        findPeak2D sol=new findPeak2D();
        // int[] res=sol.brute(arr,n,m);
        int[] res=sol.optimal(arr,n,m);
        System.out.println(res[0]+" "+res[1]);
        sc.close();
    }
}
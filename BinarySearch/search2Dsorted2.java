import java.util.Scanner;

public class search2Dsorted2 {
    public int[] brute(int [][]arr,int n,int m,int x){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(arr[i][j]==x)
                    return new int[]{i,j};
            }
            return new int[]{-1,-1};
    }
    public int BS(int[] arr,int n,int x){
        int low=0,high=n-1; 
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]<x)low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    public int[] better (int[][]arr,int n,int m,int x){
         for(int i=0;i<n;i++){
            int idx=BS(arr[i],m,x);
            if(idx!=-1)
                return new int[] {i,idx};
        }
        return new int[]{-1,-1};
    }
    public int[]optimal(int[][] arr,int n,int m,int x){
        int row=0,col=m-1;
        while(row<n && col>=0){
            if(arr[row][col]==x)
                return new int[] {row,col};
            else if(arr[row][col]<x)
                row++;
            else
                col--;
        }   
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        //individual row and col are sorted 
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j]=sc.nextInt();
        }
        System.out.println("Enter the target");
        int target= sc.nextInt();
        search2Dsorted2 sol=new search2Dsorted2();
        // int[] res=sol.brute(arr,n,m,target);
        int[] res=sol.better(arr,n,m,target);
        // int[] res=sol.optimal(arr,n,m,target);
        System.out.println(res[0]+" "+res[1]);
        sc.close();
    }
    
}

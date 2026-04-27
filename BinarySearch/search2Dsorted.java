import java.util.*;

public class search2Dsorted {
    public boolean brute(int [][]arr,int n,int m,int x){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(arr[i][j]==x)
                    return true;
        }
        return false;
    }
    public boolean BS(int[] arr,int n,int x){
        int low=0,high=n-1; 
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) return true;
            else if(arr[mid]<x)low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }
    public boolean better(int[][] arr,int n,int m,int x){
        for(int i=0;i<n;i++){
            if(arr[i][0]<=x && x<=arr[i][m-1])
                return BS(arr[i],m,x);
        }
        return false;
    }
    // hypothetically convert 2D to 1D join all rows to a single one
    public boolean optimal(int[][]arr,int n,int m,int x){
        int low=0,high=n*m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/m;
            int col=mid%m;
            if(arr[row][col]==x) return true;
            else if(arr[row][col]<x) low=mid+1;
            else
                high=mid-1;
        }
        return false;

    }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        //whole matrix is sorted
        int[][] arr1=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr1[i][j]=sc.nextInt();
        }
        System.out.println("Enter the target");
        int target= sc.nextInt();
        search2Dsorted sol=new search2Dsorted();
        // boolean res=sol.brute(arr1,n,m,target);
        // boolean res=sol.better(arr1,n,m,target);
        boolean res=sol.optimal(arr1,n,m,target);
        System.out.println(res);
        sc.close();
    }
    
}

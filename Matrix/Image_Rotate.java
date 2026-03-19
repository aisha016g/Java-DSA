import java.util.*;
public class Image_Rotate {
    public void Brute(int[][] arr){
        int n=arr.length;
        int[][] ans=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans[j][n-1-i]=arr[i][j];
            }
        }
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void optimal(int[][] arr){
        int n=arr.length;
        // transpose of matrix
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++)
            {
                int t=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=t;
            }
        }
        // reversing the rows
        for(int i=0;i<n;i++){
            int left=0,right=n-1;
            while(left<right){
                int t=arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=t;
                left++;
                right--;
            } 
        }
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] [] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                arr[i][j]=sc.nextInt();
        }
        Image_Rotate sol=new Image_Rotate();
        sol.Brute(arr);
        sc.close();
    }
}

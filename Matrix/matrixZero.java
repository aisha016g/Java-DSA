import java.util.*;
public class matrixZero {
    // Brute Force Solution
    public void Brute(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0)
                {
                    markRow(arr,i,m);
                    markCol(arr,j,n);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==-1)
                    arr[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    public int[][] markRow(int[][] arr,int i,int m){
        for(int j=0;j<m;j++){
            if(arr[i][j]!=0)arr[i][j]=-1;
        }
        return arr;
    }
    public int[][] markCol(int[][] arr,int j,int n){
        for(int i=0;i<n;i++){
            if(arr[i][j]!=0)arr[i][j]=-1;
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] [] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        matrixZero sol=new matrixZero();
        sol.Brute(arr);
        sc.close();
    }
    
}

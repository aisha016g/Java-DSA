import java.util.*;
// Better Solution
public class SetZero {

    public void Better(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int[] row=new int[n];
        int[] col=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1 || col[j]==1){
                    arr[i][j]=0;
                }
            }
        }
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    // optimal solution
    public void optimal(int[][] arr)
    {
        int n=arr.length;
        int m=arr[0].length;
        int col0=1;
        for(int i=0;i<n;i++){
            if(arr[i][0]==0)
                col0=0;
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }
        for(int i=n-1;i>=0;i--)
            {
                for(int j=m-1;j>=0;j--){
                    if(arr[i][0]==0 || arr[0][j]==0){
                        arr[i][j]=0;
                    }
                }
                if(col0==0)
                    arr[i][0]=0;
            }
            
            for(int i=0;i<n;i++){
               for(int j=0;j<m;j++){
                   System.out.print(arr[i][j]+" ");
               }
               System.out.println();
           }
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
        SetZero sol=new SetZero();
        // sol.Better(arr);
        sol.optimal(arr);
        sc.close();
    }
    
}

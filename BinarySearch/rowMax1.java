import java.util.*;

public class rowMax1 {
    public int brute(int[][]arr,int n,int m){
        int idx=-1,maxCnt=-1;
        for(int i=0;i<n;i++){
            int cntRow=0;
            for(int j=0;j<m;j++){
                cntRow+=arr[i][j];
            }
            if(cntRow>maxCnt){
            maxCnt=cntRow;
            idx=i;
            }
        }
        return idx;
    }
    int lowerBound(int [] arr,int n,int x){
        int low=0,high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
            high=mid-1;
            ans=mid;}
            else
                low=mid+1;
        }
        return ans;
    }
    public int optimal(int [][] arr,int n,int m){
        int idx=-1,maxCnt=0;
        for(int i=0;i<n;i++){
            int cnt=m-lowerBound(arr[i],m,1);
            if(cnt>maxCnt){
                maxCnt=cnt;
                idx=i;
            }
        }
        return idx;
    }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[][] arr1=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            arr1[i][j]=sc.nextInt();
        }
        rowMax1 sol=new rowMax1();
        // int res=sol.brute(arr1,n,m);
        int res=sol.optimal(arr1,n,m);
        System.out.println(res);
        sc.close();
    }
    
}

import java.util.*;

public class minRotateSortArr {
    public int optimal(int[] arr){
        int low=0,high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            //check left half sorted or not
            if(arr[low]<=arr[mid]){
                ans=Math.min(ans,arr[low]);
                low=mid+1;
            }
            else {
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;

    }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        minRotateSortArr sol=new minRotateSortArr();
        int res=sol.optimal(arr);
        System.out.println(res);
        sc.close();
    }
    
}

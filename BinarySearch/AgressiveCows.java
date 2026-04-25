import java.util.*;

public class AgressiveCows {
    public int brute(int[] arr ,int cows){
        Arrays.sort(arr);
        int n=arr.length;
        int min=arr[0];
        int max=arr[n-1];
        for(int i=1;i<=max-min;i++){
            if(canWePlace(arr,i,cows)==true)
                continue;
            else
                return i-1;
        }
        return -1;
    }
    public boolean canWePlace(int[] arr,int dist,int cows) {
        int cntCows=1;
        int lastCow=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastCow>=dist){
                cntCows++;
                lastCow=arr[i];
            }
        }
        if(cntCows>=cows) return true;
        return false;
    }
    public int optimal(int[] arr,int cows){
        Arrays.sort(arr);
        int n=arr.length;
        int min=arr[0], max=arr[n-1];
        int low=1,high=max-min;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(canWePlace(arr, mid, cows)==true)
                { 
            low=mid+1;
            ans=mid;
        }
        else
            high=mid-1;
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
         System.out.println("Enter the cows ");
        int cows=sc.nextInt();
        AgressiveCows sol=new AgressiveCows();
        int res=sol.brute(arr,cows);
        // int res=sol.optimal(arr,cows);
        System.out.println(res);
        sc.close();
    }
    
}

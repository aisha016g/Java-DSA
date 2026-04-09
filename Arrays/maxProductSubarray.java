import java.util.*;

public class maxProductSubarray {
    public int optimal(int[] arr){
        int maxi=arr[0];
        int mini=arr[0];
        int ans=arr[0];
        int currMax, currMin;
        for(int i=1;i<arr.length;i++){
            currMax=Math.max(arr[i],Math.max(maxi*arr[i],mini*arr[i]));
            currMin=Math.min(arr[i],Math.min(maxi*arr[i],mini*arr[i]));
            maxi=currMax;
            mini=currMin;
            ans=Math.max(ans,currMax);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        maxProductSubarray sol=new maxProductSubarray();
        int res=sol.optimal(arr);
        System.out.println(res);
        sc.close();
    }
    
}

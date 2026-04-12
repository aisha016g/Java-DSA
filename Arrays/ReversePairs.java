import java.util.*;

public class ReversePairs {
    public static int Brute(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2L * nums[j]) { // use 2L to avoid overflow
                    count++;
                }
            }
        }

        return count;
    }
    public int mergeS(int [] arr,int low,int high){
        if(low>=high)return 0;
        int mid=(low+high)/2;
        int cnt=0;
        cnt+=mergeS(arr,low,mid);
        cnt+=mergeS(arr,mid+1,high);
        cnt+=CountPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return cnt;
    }
    public int CountPairs(int[] arr,int low,int mid,int high){
        int right=mid+1,cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && arr[i]>2L*arr[right]){
                cnt+=(right-(mid+1));
            }
        }
        return cnt;
    }
    public void merge(int[] arr,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int idx=0;
        int[] temp=new int[high-low+1];
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right])
            {
                temp[idx++]=arr[left++];
            }
            else{
                temp[idx++]=arr[right++];
            }
        }
        while(left<=mid){
            temp[idx++]=arr[left++];
        }
        while(right<=high){
            temp[idx++]=arr[right++];
        }
        for(int i=0;i<temp.length;i++){
            arr[low+i]=temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        ReversePairs sol=new ReversePairs();
        // int res=ReversePairs.Brute(arr);
        int res=sol.mergeS(arr,0,n-1);
        System.out.println(res);
        sc.close();
    }
}

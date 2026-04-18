import java.util.*;

public class peakEle {
    public int brute(int [] arr){
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            if((i==0 || arr[i-1]<arr[i]) &&(i==n-1)||arr[i]>arr[i+1])return arr[i];
        }
        return -1;
    }
    public int optimal(int[] arr){
        int n=arr.length;
        // edge cases
        if(n==1)return 0;
        if(arr[0]>arr[1])return 0;
        if(arr[n-1]>arr[n-2])return n-1;

        int low=1,high=n-2;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
                return mid;
            else if(arr[mid]>arr[mid-1]) low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        peakEle sol=new peakEle();
        // int res=sol.brute(arr);
        int res=sol.optimal(arr);
        System.out.println(res);
        sc.close();
    }
}

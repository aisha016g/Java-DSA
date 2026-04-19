import java.util.*;

public class SingleEle {
    public int brute(int[] arr){
        int n=arr.length;
        if(n==1)return arr[0];
        for(int i=0;i<n;i++){
            if(i==0){
                if(arr[i]!=arr[i+1])return arr[i];
            }
            else if(i==n-1){
                if(arr[i]!=arr[i-1])return arr[i];
            }
            else{
                if(arr[i]!=arr[i+1] && arr[i]!=arr[i-1])
                    return arr[i];
            }
        }
        return -1;
    }
    public int optimal(int[] arr){
        int n=arr.length;
        if(n==1)return arr[0];
        if(arr[0]!=arr[1])return arr[0];
        if(arr[n-2]!=arr[n-1])return arr[n-1];
        int low=0,high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]){
                return arr[mid];
            }
            //we are in left
            if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])){
                low=mid+1;
            }
            //we are on right
            else{
                high=mid-1;
            }
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
        SingleEle sol=new SingleEle();
        // int res=sol.brute(arr);
        int res=sol.optimal(arr);
        System.out.println(res);
        sc.close();
    }
}

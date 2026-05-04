import java.util.Scanner;

public class KthMissNum {
    public int brute(int[] arr,int Kth){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=Kth)
                Kth++;
            else break;
        }
        return Kth;
    }
    public int optimal(int [] arr,int k){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<=k)
                low=mid+1;
            else
                high=mid-1;
        }
        return high+1+k;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
         System.out.println("Enter the Kth element ");
        int Kth=sc.nextInt();
        KthMissNum sol=new KthMissNum();
        int res=sol.brute(arr,Kth);
        // int res=sol.optimal(arr,Kth);
        System.out.println(res);
        sc.close();
    }
    
}

import java.util.*;

public class timesRotate {
    public int optimal(int[] arr){
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]>arr[high]){
                //move right
                low=mid+1;
            }
            else
                high=mid;
        }
        return low;
    }
       public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        timesRotate sol=new timesRotate();
        int res=sol.optimal(arr);
        System.out.println(res);
        sc.close();
    }
    
}

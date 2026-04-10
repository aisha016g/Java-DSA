import java.util.*;
public class binarySearch {
    public int iterate(int[] arr,int key)
    {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==key)
                return mid;
            else if(arr[mid]<=key)
                    low=mid+1;
                else
                    high=mid-1;
        }
        return -1;
    }
    public int recursive(int[] arr,int low,int high,int key){
    if(low>high)return -1;
        int mid=(low+high)/2;
        if(arr[mid]==key) return mid;
        if(key>arr[mid])
            return recursive(arr,mid+1,high,key);
        else
            return recursive(arr,low,mid-1,key);

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        } 
        System.out.println("Enter the key");
        int target=sc.nextInt();
        binarySearch sol=new binarySearch();
        // int result=sol.iterate(arr,target);
        int result=sol.recursive(arr,0,n-1,target);
        System.out.println(result);
        sc.close();
    }
    
    
}

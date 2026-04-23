import java.util.*;
public class BsRotatedSortArr2 {
    public boolean optimal(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==key)return true;
            else if(arr[mid]==arr[low] && arr[mid]==arr[high])
            {
                low++;
                high--;
                continue;
            }
            else if(arr[low]<=arr[mid]){
                if(arr[low]<=key && key<=arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(arr[mid]<=key && key<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
           
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter key ");
        int key=sc.nextInt();
        BsRotatedSortArr2 sol=new BsRotatedSortArr2();
        boolean res=sol.optimal(arr,key);
        System.out.println(res);
        sc.close();
    }
}

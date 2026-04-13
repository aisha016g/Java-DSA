import java.util.*;
public class firstAndLastOccur {
    public void Brute(int[] arr,int key){
        int n=arr.length;
        int first=-1,last=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==key)
            {
                if(first==-1){
                    first=i;
                }
                last=i;
            }
            
        }
        System.out.println(first+" "+last);
    }
    public int lower(int[] arr, int n, int x) {
        int ans = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    // UPPER BOUND → first index where arr[i] > x
    public int upper(int[] arr, int n, int x) {
        int ans = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public int[] firstLastPos(int[] arr, int n, int k) {
    int lb = lower(arr, n, k);
    int ub = upper(arr, n, k);

    // If element not present
    if (lb == n || arr[lb] != k) {
        return new int[]{-1, -1};
    }

    return new int[]{lb, ub - 1};

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the key");
        int key=sc.nextInt();
        firstAndLastOccur sol=new firstAndLastOccur();
        sol.Brute(arr,key);
        sc.close();
    }
    
}

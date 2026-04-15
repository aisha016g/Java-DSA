import java.util.*;
public class insertPos {

    // Function to find the insert position of x in sorted array
    public int searchInsert(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n; // Default to end if x is greater than all elements

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                // Potential answer found, try to go left
                ans = mid;
                high = mid - 1;
            } else {
                // Go right
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {

         // define input size and key
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        } 
        System.out.println("Enter the key");
        int key=sc.nextInt();
        // run search
        insertPos sol = new insertPos();
        int ans = sol.searchInsert(arr, key);
        // print result
        System.out.println(ans);
        sc.close();
    }
    
    
}

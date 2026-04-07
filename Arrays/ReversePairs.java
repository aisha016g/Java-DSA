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

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        // int res=ReversePairs.Better(arr);
        // int res=ReversePairs.Brute(arr);
        int res=ReversePairs.Brute(arr);
        System.out.println(res);
        sc.close();
    }
}
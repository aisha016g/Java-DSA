import java.util.*;

public class lowerBound {
    // LOWER BOUND → first index where arr[i] >= x
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the key");
        int target = sc.nextInt();

        lowerBound sol = new lowerBound();

        int lb = sol.lower(arr, n, target);
        int ub = sol.upper(arr, n, target);

        System.out.println("Lower Bound: " + lb);
        System.out.println("Upper Bound: " + ub);

        sc.close();
    }
}
import java.util.*;

public class kokoEatingBanana {

    // Brute Force
    public int brute(int[] arr, int h) {
        int maxI = maxEle(arr);

        for (int i = 1; i <= maxI; i++) { // speed starts from 1
            int reqTime = time(arr, i);
            if (reqTime <= h)
                return i;
        }
        return maxI; // fallback
    }

    // Calculate total hours needed at given speed
    int time(int[] arr, int speed) {
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += Math.ceil((double) arr[i] / speed);
        }

        return total;
    }

    // Find max element
    public int maxEle(int[] arr) {
        int maxi = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxi = Math.max(arr[i], maxi);
        }
        return maxi;
    }

    // Optimal (Binary Search)
    public int optimal(int[] arr, int h) {
        int low = 1, high = maxEle(arr);

        while (low <= high) {
            int mid = (low + high) / 2;
            int total = time(arr, mid);

            if (total <= h)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Tell the hours");
        int h = sc.nextInt();

        kokoEatingBanana sol = new kokoEatingBanana();

        // You can test both
        System.out.println("Brute: " + sol.brute(arr, h));
        System.out.println("Optimal: " + sol.optimal(arr, h));

        sc.close();
    }
}
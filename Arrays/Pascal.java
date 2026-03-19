import java.util.*;

public class Pascal {

    // 🔹 1. Find a single element using nCr (0-based indexing)
    // returns C(r, c)
    public long findNum(int r, int c) {
        if (c > r) return 0;

        c = Math.min(c, r - c); // optimization

        long ans = 1;

        for (int i = 0; i < c; i++) {
            ans = ans * (r - i);
            ans = ans / (i + 1);
        }

        return ans;
    }

    // 🔹 2. Print nth row (Brute using findNum)
    // Time: O(n^2)
    public void printRowBrute(int n) {
        for (int c = 0; c < n; c++) {
            System.out.print(findNum(n - 1, c) + " ");
        }
        System.out.println();
    }

    // 🔹 3. Print nth row (Optimal)
    // Time: O(n), Space: O(1)
    public void printRowOptimal(int n) {
        long ans = 1;
        System.out.print(ans + " "); // first element

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }

        System.out.println();
    }

    // 🔹 4. Print full Pascal Triangle (Optimal)
    // Time: O(n^2)
    public void printTriangle(int n) {

        for (int i = 0; i < n; i++) {

            long ans = 1;
            System.out.print(ans + " "); // first element

            for (int j = 1; j <= i; j++) {
                ans = ans * (i - j + 1);
                ans = ans / j;
                System.out.print(ans + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pascal sol = new Pascal();

        int n = sc.nextInt();

        // 🔹 Uncomment what you want to run:

        // sol.printRowBrute(n);
        // sol.printRowOptimal(n);
        sol.printTriangle(n);

        sc.close();
    }
}
import java.util.*;

public class medianMatrix {
    public int brute(int[][] arr,int n ,int m){
    ArrayList<Integer> list = new ArrayList<>();
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        list.add(arr[i][j]);
    }
}
Collections.sort(list);
return list.get((n*m)/2);
    }

    // Find minimum element (first column)
    int minEle(int[][] arr, int n) {
        int minI = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minI = Math.min(minI, arr[i][0]);
        }
        return minI;
    }

    // Find maximum element (last column)
    int maxEle(int[][] arr, int n, int m) {
        int maxI = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxI = Math.max(maxI, arr[i][m - 1]);
        }
        return maxI;
    }

    // Upper Bound: count of elements <= x in a row
    int upperBound(int[] row, int x) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low; // count of elements <= x
    }

    // Count elements <= x in whole matrix
    int countSmallerEqual(int[][] arr, int x) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += upperBound(arr[i], x);
        }
        return cnt;
    }

    public int optimal(int[][] arr, int n, int m) {
        int low = minEle(arr, n);
        int high = maxEle(arr, n, m);
        int req = (n * m) / 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            int smaller = countSmallerEqual(arr, mid);

            if (smaller <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        medianMatrix sol = new medianMatrix();
        int res = sol.optimal(arr, n, m);
        System.out.println(res);

        sc.close();
    }
}
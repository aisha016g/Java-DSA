import java.util.*;
public class CountInversions {

    public static int Brute(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    //optimal
    public int mergeS(int[] arr, int low, int high) {
        if (low >= high) return 0;

        int mid = (low + high) / 2;

        int left=mergeS(arr, low, mid);
        int right=mergeS(arr, mid + 1, high);
        int mergeCount=merge(arr, low, mid, high);
        return left+right+mergeCount;
    }

    public int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int idx = 0;
        int cnt=0;
        // merge two sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
                // Counting Inversions
                cnt+=(mid-left+1);
            }
        }

        // remaining left
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }

        // remaining right
        while (right <= high) {
            temp[idx++] = arr[right++];
        }

        // copy back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        CountInversions sol=new CountInversions();
        // int result = sol.Brute(arr);
        int result = sol.mergeS(arr,0,n-1);
        System.out.println(result);
        sc.close();
    }
}

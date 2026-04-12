import java.util.Scanner;

public class mergeSort {

    public void mergeS(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;

        mergeS(arr, low, mid);
        mergeS(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int idx = 0;

        // merge two sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort sol = new mergeSort();
        sol.mergeS(arr, 0, n - 1);

        // print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}

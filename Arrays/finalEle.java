import java.util.*;

public class finalEle {

    public static int finalElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        while (n > 1) {
            int idx = 0;

            if (cnt % 2 == 0) {
                int mini = nums[0];
                for (int t = 1; t < n; t++) {
                    if (nums[t] < mini) {
                        mini = nums[t];
                        idx = t;
                    }
                }
            } else {
                int maxi = nums[0];
                for (int t = 1; t < n; t++) {
                    if (nums[t] > maxi) {
                        maxi = nums[t];
                        idx = t;
                    }
                }
            }

            // delete element at idx
            for (int k = idx; k < n - 1; k++) {
                nums[k] = nums[k + 1];
            }

            cnt++;
            n--;
        }

        return nums[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // input array
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = finalElement(nums);

        // output
        System.out.println("Final Element: " + result);

        sc.close();
    }
}
/*You are given an integer array nums.

You repeatedly perform operations on the array until only one element remains:

On even-numbered steps (starting from 0):
Find the minimum element in the current array and delete it.
On odd-numbered steps:
Find the maximum element in the current array and delete it.
After deleting an element:
Shift the remaining elements to fill the gap.
Reduce the size of the array.

The process continues until only one element is left. */
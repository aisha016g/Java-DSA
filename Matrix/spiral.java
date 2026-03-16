import java.util.*;

public class spiral {

    public List<Integer> optimal(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int top = 0;                      // first row
        int bottom = matrix.length - 1;   // last row
        int left = 0;                     // first column
        int right = matrix[0].length - 1; // last column

        // loop continues until all rows and columns are traversed
        while (top <= bottom && left <= right) {

            // traverse the top row
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;  // top row is done, move to next row

            // traverse the right column
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;  // right column is done, move to previous column

            // check if rows are still remaining
            if (top <= bottom) {
                // traverse the bottom row
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;  // bottom row is done
            }

            // check if columns are still remaining
            if (left <= right) {
                // traverse the left column
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;  // left column is done
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        // input matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        spiral sol = new spiral();

        List<Integer> result = sol.optimal(arr);

        System.out.println(result);

        sc.close();
    }
}
class maxPathSum {

    // Definition for binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    // Global variable to store maximum answer
    int maxSum = Integer.MIN_VALUE;

    // Function to calculate maximum gain
    public int maxGain(TreeNode root) {

        // Base case
        if(root == null)
            return 0;

        // Find left gain
        int left = Math.max(0, maxGain(root.left));

        // Find right gain
        int right = Math.max(0, maxGain(root.right));

        // Current path sum
        int currentPath = root.val + left + right;

        // Update maximum answer
        maxSum = Math.max(maxSum, currentPath);

        // Return maximum gain to parent
        return root.val + Math.max(left, right);
    }

    // Main function
    public int maxSum(TreeNode root) {

        maxGain(root);

        return maxSum;
    }

    // Main method
    public static void main(String[] args) {

        maxPathSum obj = new maxPathSum();

        /*
                -10
                /  \
               9   20
                  /  \
                 15   7
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans = obj.maxSum(root);

        System.out.println("Maximum Path Sum = " + ans);
    }
}
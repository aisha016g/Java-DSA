// Definition for binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {

    // Variable to store maximum diameter
    int diameter = 0;

    // Function to find height
    public int height(TreeNode root) {

        // Base case
        if(root == null)
            return 0;

        // Find left subtree height
        int left = height(root.left);

        // Find right subtree height
        int right = height(root.right);

        // Update diameter
        diameter = Math.max(diameter, left + right);

        // Return current node height
        return 1 + Math.max(left, right);
    }

    // Function to return diameter
    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }

    // Main function
    public static void main(String[] args) {

        Solution obj = new Solution();

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int ans = obj.diameterOfBinaryTree(root);

        System.out.println("Diameter = " + ans);
    }
}
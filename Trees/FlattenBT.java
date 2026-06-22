import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    // Print flattened linked list using right pointers
    public void printLinkedList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }

 // Approach 1 : Recursive (O(n²))
    public void flatten(TreeNode root) {

        // Base Case
        if (root == null) return;

        // Flatten left and right subtrees first
        flatten(root.left);
        flatten(root.right);

        // Save original right subtree
        TreeNode temp = root.right;

        // Move left subtree to right
        root.right = root.left;
        root.left = null;

        // Find tail of new right subtree
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        // Attach original right subtree
        curr.right = temp;
    }

    // Approach 2 : Stack (Iterative Preorder)
    // Time : O(n)
    // Space: O(n)
    public void stackIterative(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();

            // Push right first so left is processed first
            if (curr.right != null)
                st.push(curr.right);

            if (curr.left != null)
                st.push(curr.left);

            // Connect current node to next preorder node
            if (!st.isEmpty())
                curr.right = st.peek();

            // Flatten => no left pointers
            curr.left = null;
        }
    }

    // Approach 3 : Morris Traversal
    // Time : O(n)
    // Space: O(1)
    public void morrisFlatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {

                // Find rightmost node of left subtree
                TreeNode pred = curr.left;

                while (pred.right != null) {
                    pred = pred.right;
                }
                // Connect predecessor with original right subtree
                pred.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;

                // Remove left pointer
                curr.left = null;
            }
            // Move to next node
            curr = curr.right;
        }
    }
}

public class FlattenBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        Solution obj = new Solution();

        // Uncomment only ONE approach at a time

        // obj.flatten(root);          // Recursive O(n²)

        // obj.stackIterative(root);   // Stack O(n)

        obj.morrisFlatten(root);       // Morris O(1) Space

        System.out.println("Flattened Linked List:");
        obj.printLinkedList(root);
    }
}
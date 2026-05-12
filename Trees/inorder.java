import java.util.*;

// Solution class
class InOrderSolution {

    // 🔁 Recursive Inorder
    private void recursive(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;

        recursive(root.left, arr);
        arr.add(root.data);
        recursive(root.right, arr);
    }

    public List<Integer> inorderRecursive(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        recursive(root, arr);
        return arr;
    }

    // 🔁 Iterative Inorder (using stack)
    public List<Integer> inorderIterative(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Go to leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process node
            curr = stack.pop();
            arr.add(curr.data);

            // Move to right subtree
            curr = curr.right;
        }

        return arr;
    }
}

// Main class
public class inorder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InOrderSolution sol = new InOrderSolution();

        // Recursive
        List<Integer> rec = sol.inorderRecursive(root);
        System.out.println("Recursive Inorder:");
        for (int i : rec) {
            System.out.print(i + " ");
        }

        // Iterative
        List<Integer> iter = sol.inorderIterative(root);
        System.out.println("\nIterative Inorder:");
        for (int i : iter) {
            System.out.print(i + " ");
        }
    }
}
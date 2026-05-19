import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class PreSolution {

    private void recursive(TreeNode root, List<Integer> arr) {
        if (root == null) return;

        arr.add(root.data);
        recursive(root.left, arr);
        recursive(root.right, arr);
    }

    public List<Integer> preorderRecursive(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        recursive(root, arr);
        return arr;
    }

    public List<Integer> preorderIterative(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) return arr;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            arr.add(curr.data);

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return arr;
    }
}
public class Preorder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PreSolution sol = new PreSolution();

        List<Integer> rec = sol.preorderRecursive(root);
        System.out.println("Recursive Preorder:");
        for (int i : rec) {
            System.out.print(i + " ");
        }

        List<Integer> iter = sol.preorderIterative(root);
        System.out.println("\nIterative Preorder:");
        for (int i : iter) {
            System.out.print(i + " ");
        }
    }
}


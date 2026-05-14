import java.util.*;

public class Postorder {
    public static void main(String[] args) {

        // Creating tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostorderSolution sol = new PostorderSolution();

        // Recursive Postorder
        List<Integer> rec = sol.postorderRecursive(root);
        System.out.println("Recursive Postorder:");
        for (int i : rec) {
            System.out.print(i + " ");
        }

        // Iterative Postorder
        List<Integer> iter = sol.postorderIterative(root);
        System.out.println("\nIterative Postorder:");
        for (int i : iter) {
            System.out.print(i + " ");
        }
    }
}

// Postorder solution class
class PostorderSolution {

    // Recursive Postorder (L R N)
    private void recursive(TreeNode root, List<Integer> arr) {
        if (root == null) return;

        recursive(root.left, arr);
        recursive(root.right, arr);
        arr.add(root.data);  // Node at last
    }

    public List<Integer> postorderRecursive(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        recursive(root, arr);
        return arr;
    }

    // Iterative Postorder (2 stacks method)
   public List<Integer> postorderIterative(TreeNode root) {
    List<Integer> arr = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    TreeNode lastVisited = null;

    while (curr != null || !stack.isEmpty()) {

        // Step 1: Go left as much as possible
        if (curr != null) {
            stack.push(curr);
            curr = curr.left;
        } 
        else {
            TreeNode peekNode = stack.peek();

            // Step 2: If right exists and not processed → go right
            if (peekNode.right != null && lastVisited != peekNode.right) {
                curr = peekNode.right;
            } 
            else {
                // Step 3: Process node
                arr.add(peekNode.data);
                lastVisited = stack.pop();
            }
        }
    }

    return arr;
}
}
    


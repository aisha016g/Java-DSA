class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {
    public Node delete(Node root, Node key) {

        // Base case: key not found
        if (root == null)
            return null;

        // Search in left subtree
        if (key.data < root.data) {
            root.left = delete(root.left, key);
        }

        // Search in right subtree
        else if (key.data > root.data) {
            root.right = delete(root.right, key);
        }

        // Node found
        else {

            // Case 1 & 2:
            // No left child OR only right child
            if (root.left == null) {
                return root.right;
            }

            // No right child OR only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3:
            // Node has two children

            // Find inorder successor
            Node succ = findSuccessor(root.right);

            // Copy successor value into current node
            root.data = succ.data;

            // Delete the original successor node
            root.right = delete(root.right, succ);
        }

        return root;
    }

    // Finds the smallest node in a subtree
    // (leftmost node)
    public Node findSuccessor(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}

public class DeleteNodeBST {

    public static void main(String[] args) {

        Node root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.print("Before deletion: ");
        inorder(root);
        System.out.println();

        Node key = new Node(70);

        Solution sol = new Solution();
        root = sol.delete(root, key);

        System.out.print("After deletion: ");
        inorder(root);
    }

    public static Node insert(Node root, int key) {

        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);

        else if (key > root.data)
            root.right = insert(root.right, key);

        return root;
    }

    public static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
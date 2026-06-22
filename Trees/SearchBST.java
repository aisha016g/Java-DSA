class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    // Insert into BST
    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Search in BST
    public boolean find(Node root, int key) {
        while (root != null) {

            if (root.data == key) {
                return true;
            }

            if (key > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return false;
    }
}

public class SearchBST {
    public static void main(String[] args) {

        Node root = null;
        Solution bst = new Solution();

        root = bst.insert(root, 50);
        root = bst.insert(root, 30);
        root = bst.insert(root, 70);
        root = bst.insert(root, 20);
        root = bst.insert(root, 40);
        root = bst.insert(root, 60);
        root = bst.insert(root, 80);

        int key = 60;

        if (bst.find(root, key)) {
            System.out.println("\n" + key + " found in BST");
        } else {
            System.out.println("\n" + key + " not found in BST");
        }
    }
}
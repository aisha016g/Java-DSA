class node {
    int data;
    node left;
    node right;
    node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {
    public node insertion(node root, node key) {
        if (root == null)
            return key;

        node curr = root;

        while (true) {

            if (key.data < curr.data) {
                if (curr.left == null) {
                    curr.left = key;
                    break;
                }
                curr = curr.left;
            }

            else if (key.data > curr.data) {
                if (curr.right == null) {
                    curr.right = key;
                    break;
                }
                curr = curr.right;
            }

            else {
                break; // duplicate value
            }
        }
        return root;
    }
}

public class InsertNode {

    public static void inorder(node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        node root = null;

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 90);
        root = insert(root, 55);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 60);

        System.out.print("Before insertion: ");
        inorder(root);
        System.out.println();

        node key = new node(75);

        Solution sol = new Solution();
        root = sol.insertion(root, key);

        System.out.print("After insertion: ");
        inorder(root);
    }

    public static node insert(node root, int key) {

        if (root == null)
            return new node(key);

        if (key < root.data)
            root.left = insert(root.left, key);

        else if (key > root.data)
            root.right = insert(root.right, key);

        return root;
    }
}
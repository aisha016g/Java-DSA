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
    int cnt = 0;
    node ans = null;

    public node minNode(node root, int kth) {
        inorder(root, kth);
        return ans;
    }

    private void inorder(node root, int kth) {
        if (root == null)
            return;

        // Left
        inorder(root.left, kth);

        // Visit current node
        cnt++;

        if (cnt == kth) {
            ans = root;
            return;
        }

        // Right
        inorder(root.right, kth);
    }
}

public class KthSmallest {
    public static void main(String[] args) {
        node root = null;

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 90);
        root = insert(root, 40);
        root = insert(root, 80);
        root = insert(root, 70);

        int kth = 3;

        Solution sol = new Solution();
        node result = sol.minNode(root, kth);
        System.out.println("Kth smallest = " + result.data);
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
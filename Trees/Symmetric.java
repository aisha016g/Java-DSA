import java.util.*;

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
    public boolean compare(node first, node second) {
        if (first == null && second == null)
            return true;

        if (first == null || second == null)
            return false;

        if (first.data != second.data)
            return false;

        return compare(first.left, second.right) &&
               compare(first.right, second.left);
    }

    public boolean symmet(node root) {
        if (root == null)
            return true;

        return compare(root.left, root.right);
    }
}

public class Symmetric {
    public static void main(String[] args) {

        node root = new node(1);
        root.left = new node(2);
        root.right = new node(2);

        root.left.left = new node(3);
        root.left.right = new node(4);

        root.right.left = new node(4);
        root.right.right = new node(3);

        Solution sol = new Solution();

        boolean ans = sol.symmet(root);
        System.out.println(ans);
    }
}
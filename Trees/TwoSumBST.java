import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BSTIterator {

    Stack<Node> st = new Stack<>();
    boolean reverse;

    public BSTIterator(Node root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    private void pushAll(Node root) {

        while (root != null) {
            st.push(root);

            if (reverse)
                root = root.right;
            else
                root = root.left;
        }
    }

    public int next() {

        Node curr = st.pop();

        if (!reverse)
            pushAll(curr.right);
        else
            pushAll(curr.left);

        return curr.data;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

class Solution {

    public boolean findTarget(Node root, int k) {

        if (root == null)
            return false;

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();   // smallest
        int j = right.next();  // largest

        while (i < j) {

            int sum = i + j;

            if (sum == k)
                return true;

            else if (sum < k)
                i = left.next();

            else
                j = right.next();
        }

        return false;
    }
}

public class TwoSumBST {

    public static void main(String[] args) {

        /*
                  5
                /   \
               3     6
              / \     \
             2   4     7

            Target = 9

            2 + 7 = 9
        */

        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(6);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.right = new Node(7);

        Solution obj = new Solution();

        int k = 9;

        if (obj.findTarget(root, k))
            System.out.println("Target Found");
        else
            System.out.println("Target Not Found");
    }
}
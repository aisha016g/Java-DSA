import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class NodeValue {

    int minNode;
    int maxNode;
    int maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

class Solution {

    public int largestBST(Node root) {
        return helper(root).maxSize;
    }

    private NodeValue helper(Node root) {

        if (root == null) {
            return new NodeValue(
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE,
                    0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if (left.maxNode < root.data &&
                root.data < right.minNode) {

            return new NodeValue(
                    Math.min(root.data, left.minNode),
                    Math.max(root.data, right.maxNode),
                    left.maxSize + right.maxSize + 1
            );
        }

        return new NodeValue(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.maxSize, right.maxSize)
        );
    }
}
public class LargestBST {

    public static void main(String[] args) {

        /*
                10
               /  \
              5   15
             / \  / \
            1  8 7 20
        */

        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(1);
        root.left.right = new Node(8);

        root.right.left = new Node(7);
        root.right.right = new Node(20);

        Solution obj = new Solution();

        System.out.println(
                "Largest BST Size = "
                        + obj.largestBST(root)
        );
    }
}
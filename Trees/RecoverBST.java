import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    Node first;
    Node middle;
    Node last;
    Node prev;

    public void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        // Violation found
        if (prev != null && root.data < prev.data) {

            // First violation
            if (first == null) {
                first = prev;
                middle = root;
            }

            // Second violation
            else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }

    public void recoverTree(Node root) {
        first = middle = last = null;

        prev = new Node(Integer.MIN_VALUE);

        inorder(root);

        // Non-adjacent swapped nodes
        if (first != null && last != null) {

            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }

        // Adjacent swapped nodes
        else if (first != null && middle != null) {

            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    // Inorder traversal for checking
    public void printInorder(Node root) {

        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}

public class RecoverBST {

    public static void main(String[] args) {

        /*
               Original BST

                     4
                   /   \
                  2     6
                 / \   / \
                1  3  5  7

               Swap 3 and 6

                     4
                   /   \
                  2     3
                 / \   / \
                1  6  5  7
        */

        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(3); // should be 6

        root.left.left = new Node(1);
        root.left.right = new Node(6); // should be 3

        root.right.left = new Node(5);
        root.right.right = new Node(7);

        Solution obj = new Solution();

        System.out.println("Before Recovery:");
        obj.printInorder(root);
        System.out.println();

        obj.recoverTree(root);

        System.out.println("\nAfter Recovery:");
        obj.printInorder(root);
        System.out.println();
    }
}
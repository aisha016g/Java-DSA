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

    // ==========================================
    // BRUTE FORCE
    // ==========================================

    public Node successorBrute(Node root, Node key) {

        ArrayList<Node> inorder = new ArrayList<>();

        inorder(root, inorder);

        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).data == key.data) {
                return inorder.get(i + 1);
            }
        }

        return null;
    }

    private void inorder(Node root, ArrayList<Node> list) {

        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    // ==========================================
    // BETTER / OPTIMAL
    // ==========================================

    public Node successorOptimal(Node root, Node key) {

        Node succ = null;

        while (root != null) {

            if (key.data >= root.data) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }

        return succ;
    }
}

public class InorderSuccessor {

    public static void main(String[] args) {

        /*
                 5
               /   \
              3     7
             / \   / \
            2  4  6   8
        */

        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(8);

        Solution obj = new Solution();

        Node key = root.left.right; // Node 4

        // Brute Force
        Node ans1 = obj.successorBrute(root, key);

        System.out.println("Brute Force:");
        if (ans1 != null)
            System.out.println("Successor = " + ans1.data);
        else
            System.out.println("No Successor");

        // Optimal
        Node ans2 = obj.successorOptimal(root, key);

        System.out.println("\nOptimal:");
        if (ans2 != null)
            System.out.println("Successor = " + ans2.data);
        else
            System.out.println("No Successor");
    }
}
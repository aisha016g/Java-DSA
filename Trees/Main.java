// Node class for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {

    // ---------------- BRUTE FORCE APPROACH ----------------

    public int diameterBrute(Node root) {

        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currentDiameter = leftHeight + rightHeight;

        int leftDiameter = diameterBrute(root.left);
        int rightDiameter = diameterBrute(root.right);

        return Math.max(currentDiameter,
                Math.max(leftDiameter, rightDiameter));
    }

    // Height function used in brute force
    public int height(Node root) {

        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    // ---------------- OPTIMAL APPROACH ----------------

    public int diameterOptimal(Node root) {

        int[] diameter = new int[1];

        heightOptimal(root, diameter);

        return diameter[0];
    }

    // Height function for optimal approach
    private int heightOptimal(Node node, int[] diameter) {

        if (node == null)
            return 0;

        int leftH = heightOptimal(node.left, diameter);
        int rightH = heightOptimal(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        // Creating binary tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        Solution obj = new Solution();

        // Brute Force
        int bruteAns = obj.diameterBrute(root);
        System.out.println("Diameter using Brute Force: " + bruteAns);

        // Optimal
        int optimalAns = obj.diameterOptimal(root);
        System.out.println("Diameter using Optimal Approach: " + optimalAns);
    }
}
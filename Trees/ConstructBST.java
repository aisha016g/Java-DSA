import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BSTFromPreorder {
    public Node buildBrute(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    private Node buildTree(int[] pre, int ps, int pe,
                           int[] in, int is, int ie,
                           HashMap<Integer, Integer> map) {

        if (ps > pe || is > ie)
            return null;

        Node root = new Node(pre[ps]);

        int idx = map.get(pre[ps]);
        int leftSize = idx - is;

        root.left = buildTree(pre,ps + 1,ps + leftSize,in,is,idx - 1,map);

        root.right = buildTree(pre,ps + leftSize + 1,pe,in,idx + 1,ie,map);

        return root;
    }

    public Node buildBetter(int[] preorder) {

        Node root = null;

        for (int val : preorder) {
            root = insert(root, val);
        }

        return root;
    }

    private Node insert(Node root, int val) {

        if (root == null)
            return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    private int idx = 0;

    public Node buildOptimal(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MAX_VALUE);
    }

    private Node build(int[] preorder, int bound) {

        if (idx == preorder.length ||
                preorder[idx] > bound)
            return null;

        Node root = new Node(preorder[idx++]);

        root.left = build(preorder, root.data);

        root.right = build(preorder, bound);

        return root;
    }

    public void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class ConstructBST {

    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        BSTFromPreorder obj = new BSTFromPreorder();

        // ---------------- Brute ----------------

        Node root1 = obj.buildBrute(preorder);

        System.out.println("Brute Force:");
        obj.inorder(root1);
        System.out.println();

        // ---------------- Better ----------------

        Node root2 = obj.buildBetter(preorder);

        System.out.println("Better:");
        obj.inorder(root2);
        System.out.println();

        // ---------------- Optimal ----------------

        Node root3 = obj.buildOptimal(preorder);

        System.out.println("Optimal:");
        obj.inorder(root3);
        System.out.println();
    }
}
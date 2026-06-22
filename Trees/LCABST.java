
class SolutionLCA {
    public node lca(node root, node x, node y) {

        if (root == null)
            return null;

        // Both nodes lie in right subtree
        if (root.data < x.data && root.data < y.data)
            return lca(root.right, x, y);

        // Both nodes lie in left subtree
        if (root.data > x.data && root.data > y.data)
            return lca(root.left, x, y);

        // Split point found
        return root;
    }
}

public class LCABST {

    public static void main(String[] args) {

        node root = new node(6);
        root.left = new node(2);
        root.right = new node(8);

        root.left.left = new node(0);
        root.left.right = new node(4);

        root.left.right.left = new node(3);
        root.left.right.right = new node(5);

        root.right.left = new node(7);
        root.right.right = new node(9);

        SolutionLCA obj = new SolutionLCA();

        node x = root.left;              // 2
        node y = root.left.right;        // 4

        node ans = obj.lca(root, x, y);

        System.out.println("LCA: " + ans.data);
    }
}
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class PreInPostSol {
    public void Traverse(TreeNode root) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root, 1));
        List<Integer> Pre = new ArrayList<>();
        List<Integer> In = new ArrayList<>();
        List<Integer> Post = new ArrayList<>();
        if (root == null)
            return;
        while (!st.isEmpty()) {
            Pair it = st.pop();
            if (it.num == 1) {
                Pre.add(it.node.data);
                it.num++;
                st.push(it);
                if (it.node.left != null)
                    st.push(new Pair(it.node.left, 1));
            } else if (it.num == 2) {
                In.add(it.node.data);
                it.num++;
                st.push(it);
                if (it.node.right != null)
                    st.push(new Pair(it.node.right, 1));
            } else {
                Post.add(it.node.data);
            }
        }
        for (int i : Pre)
            System.out.print(i + " ");
        System.out.println();
        for (int i : In)
            System.out.print(i + " ");
        System.out.println();
        for (int i : Post)
            System.out.print(i + " ");
    }
}

public class PreInPostTraverse {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        PreInPostSol sol = new PreInPostSol();
        sol.Traverse(root);
    }

}

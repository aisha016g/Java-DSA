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

class BalanceSol {

    // height function
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // brute force check
    public boolean brute(TreeNode root) {
        if (root == null) return true;

        int lt = height(root.left);
        int rt = height(root.right);

        if (Math.abs(lt - rt) > 1) return false;

        return brute(root.left) && brute(root.right);
    }

    // optimal check using height with -1 sentinel for imbalance
    public int optimal(TreeNode root) {
        if(root == null) return 0;
        int lt=optimal(root.left);
        if(lt==-1) return -1;
        int rt=optimal(root.right);
        if(rt==-1) return -1;
        else 
            return 1+Math.max(lt,rt);
    }
}

public class balansedBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BalanceSol sol = new BalanceSol();
        // System.out.println(sol.brute(root)); // true
        System.out.println(sol.optimal(root)); // true
    }   
}
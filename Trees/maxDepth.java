class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        data = val;
        left = null;
        right = null;
    }
}
public class maxDepth {
    public int height(TreeNode root){
        if(root == null) return 0;
        int lt = height(root.left);
        int rt = height(root.right);
        return 1 + Math.max(lt, rt);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        maxDepth sol = new maxDepth();
        System.out.println(sol.height(root));
    }
}

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}


class Solution{
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){

            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;

                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root){
    ArrayList<Integer> ans = new ArrayList<>();
    TreeNode curr = root;

    while(curr != null){

        if(curr.left == null){
            ans.add(curr.val);
            curr = curr.right;
        }
        else{
            TreeNode prev = curr.left;

            while(prev.right != null && prev.right != curr){
                prev = prev.right;
            }

            if(prev.right == null){
                ans.add(curr.val);   // Visit BEFORE going left
                prev.right = curr;
                curr = curr.left;
            }
            else{
                prev.right = null;
                curr = curr.right;
            }
        }
    }

    return ans;
}
}
  
public class MorrisInorder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution obj = new Solution();

        List<Integer> ans = obj.inorderTraversal(root);

        System.out.println(ans);
    }
}
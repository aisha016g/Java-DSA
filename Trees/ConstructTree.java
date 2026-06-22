import java.util.*;
// preorder and inorder
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution{
    int preIndex=0;
    public void inorderTraversal(Node root){
        if(root==null) return ;

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public Node Build(int[] preorder, int inStart, int inEnd, HashMap<Integer,Integer> mp){
        if(inStart > inEnd) return null;

        Node root = new Node(preorder[preIndex]);
        preIndex++;

        int inRoot = mp.get(root.data);
        root.left = Build(preorder, inStart,inRoot-1,mp);
        root.right = Build(preorder, inRoot+1,inEnd,mp);
        return root;
    }

    public Node buildTree(int[] preorder, int[] inorder){
        HashMap<Integer,Integer> mp = new HashMap<>();

        int inStart = 0 , inEnd =inorder.length -1;
        // putting inorder with it's index in map
        for(int i=0 ; i<inorder.length ; i++)
            mp.put(inorder[i],i);
        return Build(preorder, inStart, inEnd, mp);
        
    }
}

public class ConstructTree {
      public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution obj = new Solution();

        Node root = obj.buildTree(preorder, inorder);

        System.out.println("Inorder Traversal of Constructed Tree:");
        obj.inorderTraversal(root);
    }
}
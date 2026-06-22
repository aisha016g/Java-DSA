import java.util.*;
// postorder and inorder
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

class Solution {
    public void inorderTraversal(Node root){
        if(root == null) return ;

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);

    }

    int postindex;
    public Node Build(int[] postorder, int inStart,int inEnd, HashMap<Integer,Integer> mp){
        if(inStart > inEnd) return null;

        Node root = new Node(postorder[postindex]);
        postindex--;
        
        int inRoot = mp.get(root.data);

        root.right = Build(postorder,inRoot+1, inEnd, mp);
        root.left = Build(postorder, inStart, inRoot-1, mp);
        return root;
    }

    public Node buildTree(int[]postorder, int[] inorder){
        HashMap<Integer,Integer> mp = new HashMap<>();

        postindex = postorder.length -1;
        int inStart = 0 ,inEnd = inorder.length-1;
        for(int i=0 ; i < inorder.length ; i++){
            mp.put(inorder[i] , i);
        }
        return Build(postorder,inStart,inEnd,mp);
    }
}
public class ConstructTree2 {
    public static void main(String[] args) {

        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution obj = new Solution();

        Node root = obj.buildTree(postorder, inorder);

        System.out.println("Inorder Traversal of Constructed Tree:");
        obj.inorderTraversal(root);
    }
}

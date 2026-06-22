import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution{
    public int countNodes(Node root){
        if(root == null)
            return 0;

        int leftHt = leftHeight(root);
        int rightHt = rightHeight(root);
        
        if(leftHt == rightHt)
            return (int)Math.pow(2,leftHt) -1;

        else
            return 1 + countNodes(root.left) +countNodes(root.right);
    }


    public int leftHeight(Node root){
        int ht=0;
        Node curr=root;
        while(curr != null){
            curr=curr.left;
            ht++;
        }
        return ht;
    }
    public int rightHeight(Node root){
        int ht=0;
        Node curr=root;
        while(curr != null){
            curr=curr.right;
            ht++;
        }
        return ht;
    }
}
public class CountNodesBT {
    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);

        Solution obj = new Solution();

        int ans = obj.countNodes(root);

        System.out.println("Total Nodes = " + ans);
    }
}
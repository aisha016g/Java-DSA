import java.util.*;
class node{
    int data;
    node left;
    node right;
node(int val){
    data=val;
    left=right=null;
}
}
class Solution{
    public boolean check(node root){
        if(root==null) return true;

        if(root.left==null && root.right== null) return true;

        int leftVal=0,rightVal=0;

        if(root.left!=null)
             leftVal=root.left.data;
        if(root.right!=null)
             rightVal=root.right.data;
            
        int sum=leftVal+rightVal;
        boolean current=root.data==sum;
        if(current)
            return current && check(root.right) && check(root.left);
        return false;
    }
}
public class ChildrenSum {
     public static void main(String[] args) {
     node root=new node(10);
     root.left=new node(8);
     root.right=new node(2);
     root.left.left=new node(4);
     root.left.right=new node(4);
    
     Solution sol=new Solution();
     System.out.println(sol.check(root));
    }
}

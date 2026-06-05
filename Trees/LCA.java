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
    public node ancestor(node root,int x,int y){
        if(root==null ) return null;
        if( root.data==x || root.data==y) 
            return root;
        node leftSide=ancestor(root.left,x,y);
        node rightSide=ancestor(root.right,x,y);
        if(leftSide!=null && rightSide!=null)
            return root;
        if(leftSide != null && rightSide== null) return leftSide;
        if(leftSide == null && rightSide != null) return rightSide;
        else// both left and right are null
            return null;

    }
}

public class LCA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
     node root=new node(1);
     root.left=new node(2);
     root.right=new node(3);
     root.left.left=new node(4);
     root.left.right=new node(5);
     root.left.right.left=new node(6);
     root.left.right.right=new node(7);
     int x=sc.nextInt();
     int y=sc.nextInt();
     Solution sol=new Solution();
     node ans = sol.ancestor(root,x,y);
     if(ans!=null)
     System.out.println(ans.data);
    else
        System.out.println("NO LCA found !! ");
     sc.close();
    }   
}

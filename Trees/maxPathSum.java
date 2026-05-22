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
class Sol{
    public int brute(node root){
        
    }
}

class maxPathSum {
    public static void main(String[] args) {
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.right.left=new node(4);
        root.right.right=new node(5);

    }
}
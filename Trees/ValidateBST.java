import java.util.*;
class Solution{
    public boolean isValid(node root){
        if(root == null)
            return true;

        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }

    public boolean validate(node root,long min,long max){
        if(root == null) return true;

        if(root.data <= min || root.data >= max)
            return false;

        boolean LeftTree = validate(root.left,min,root.data);
        boolean RightTree = validate(root.right,root.data,max);

        if(LeftTree && RightTree)
            return true;
        return false;
    }
}

public class ValidateBST {
    public static void main(String[] args) {
     
        node root = null;
        
        root = insert(root,50);
        root = insert(root,40);
        root = insert(root,90);
        root = insert(root,10);
        root = insert(root,70);
        root = insert(root,60);
        root = insert(root,20);

        Solution sol = new Solution();
        System.out.println(sol.isValid(root));
    }

    public static node insert(node root,int key){
        if(root == null)
            return new node(key);
        
        if(root.data < key)
            root.right = insert(root.right,key);
        else if( root.data > key)
            root.left = insert(root.left,key);
        return root;
    }
    
}

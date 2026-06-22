class Node{
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution{
    public int findCeil(Node root,int key){
        int ceil = -1;
        while(root != null){
            if(root.data == key)
                return root.data;

            else if(root.data > key)
            {
                ceil = root.data;
                root = root.left;
            }
            else{// root.data < key
                root = root.right;
            }

        }
        return ceil;
    }
}
public class CeilBST {
    public static void main(String[] args) {
        Node root = null;
        
        root = insert(root,50);
        root = insert(root,30);
        root = insert(root,70);
        root = insert(root,20);
        root = insert(root,40);
        root = insert(root,60);
        root = insert(root,80);
        int key = 35;
        
        Solution sol = new Solution();
        System.out.println(sol.findCeil(root,key));

    }
    public static Node insert(Node root,int key) {
        if(root == null){
            return new Node(key);
        }
        if(key < root.data){
            root.left = insert(root.left,key);
        }
        else if(key > root.data){
            root.right = insert(root.right, key);
        }
        return root;
    } 
}

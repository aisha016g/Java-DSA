class node {
    int data;
    node left;
    node right;
    node(int val){
        data=val;
        left = right = null;
    }
}

class Solution{
    public int findFloor(node root,int key){
        int floor = -1;

        while( root != null){
            if(root.data == key)
                return root.data;

            if(root.data < key){
                floor = root.data;
                root = root.right;
            }
            else{ 
                //root.data > key
                root = root.left;
            }
        }
        return floor;
    }
}

public class floorBST {
    public static void main(String[] args){
        node root = null;

        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,50);
        root = insert(root,80);
        root = insert(root,10);
        root = insert(root,90);
        root = insert(root,45);
        root = insert(root,35);
        int key = 18;

        Solution sol = new Solution();
        System.out.println(sol.findFloor(root,key));
    }

    public static node insert(node root, int key){
        if(root == null)
        {
            return new node(key);
        }

        else if(root.data > key){
            root.left = insert(root.left,key);
        }

        else if(root.data < key){
            root.right = insert(root.right,key);
        }
        return root;
    }
}

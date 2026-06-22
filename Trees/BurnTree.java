import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        data = val;
        left = null;
        right = null;
    }
}
class Solution{
    public HashMap<Node,Node> parentMap(Node root){
        HashMap<Node,Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr.left!=null)
            {
                mp.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                mp.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        return mp;
    }
   
    public int burn(Node root,Node target){
        HashMap<Node, Node> parentMp = parentMap(root);
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> vis = new HashSet<>();

        int time=0;
        q.add(target);
        vis.add(target);
        
        
        while(!q.isEmpty()){
            
            int size = q.size();
            boolean fireSpread = false;
            for(int i=0;i<size;i++){
            Node curr = q.remove();

                if(curr.left != null && !vis.contains(curr.left))
                {
                    fireSpread=true;
                    q.add(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right != null && !vis.contains(curr.right))
                {
                    fireSpread=true;
                    q.add(curr.right);
                    vis.add(curr.right);
                }
                Node parent = parentMp.get(curr);
                if(parent!=null && !vis.contains((parent)))
                {
                    fireSpread=true;
                    q.add(parent);
                    vis.add(parent);
                }
            }
            if (fireSpread)
            time++;
        }
        return time;
    }
}
public class BurnTree {
    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution sol = new Solution();

        // Target node = 5
        Node target = root.left.right;

        int time = sol.burn(root, target);

        System.out.println("Time to burn tree: " + time);
    }
}
 
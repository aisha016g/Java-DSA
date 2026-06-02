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
class Pair{
    int col;
    node node;
Pair(node node,int col)
{
    this.col=col;
    this.node=node;
}
}
class Solution{
    public List<Integer> View(node root){
    List<Integer> ans=new ArrayList<>();
    // Edge case: empty tree
    if(root==null) return ans;

    Queue<Pair> q=new LinkedList<>();

    // HD (Horizontal Distance) -> Bottommost node value
    TreeMap<Integer,Integer> mp=new TreeMap<>();

    // Start BFS from root at HD = 0
    q.add(new Pair(root,0));

    while(!q.isEmpty()){

        Pair p=q.remove();

        int col=p.col;
        node curr=p.node;

        // For Bottom View, always overwrite.
        // The last node seen at a column becomes the answer.
        mp.put(col,p.node.data);

        // Left child lies one column to the left
        if(curr.left!=null)
            q.add(new Pair(curr.left,col-1));

        // Right child lies one column to the right
        if(curr.right!=null)
            q.add(new Pair(curr.right,col+1));
    }

    // TreeMap gives columns in sorted order (left -> right)
    for(Map.Entry<Integer,Integer> i:mp.entrySet())
        ans.add(i.getValue());

    return ans;
}
}
public class Bottom {
    public static void main(String[] args) {
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        Solution sol=new Solution();
        List<Integer> ans=sol.View(root);
        System.out.println(ans);
        }
    
}

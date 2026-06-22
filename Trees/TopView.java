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
        if(root==null) return ans;
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.remove();
            int col=p.col;
            node curr=p.node;
            if(!mp.containsKey(col)){
                mp.put(col,p.node.data);
            }
            if(curr.left!=null) q.add(new Pair(curr.left,col-1));
            if(curr.right!=null) q.add(new Pair(curr.right,col+1));
        }
        for(Map.Entry<Integer,Integer> i:mp.entrySet())
            ans.add(i.getValue());
        return ans;
    }
}
public class TopView {
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

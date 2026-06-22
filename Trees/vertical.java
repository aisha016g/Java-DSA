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
Pair(node node,int col){
    this.node=node;
    this.col=col;
}
}

class Solution{
    public List<List<Integer>> Traverse(node root){
        TreeMap<Integer,List<Integer>> mp= new TreeMap<>();

        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            Pair p=q.remove();

            if(!mp.containsKey(p.col)){
                List<Integer> list=new ArrayList<>();
                list.add(p.node.data);
                mp.put(p.col,list);
            }
            else{
                mp.get(p.col).add(p.node.data);
            }

            if(p.node.left!=null)
            q.add(new Pair(p.node.left,p.col-1));
        
            if(p.node.right!=null)
            q.add(new Pair(p.node.right,p.col+1));
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> i:mp.entrySet()){
            ans.add(i.getValue());
        }
        return ans;
    }
}
public class vertical {
    public static void main(String[] args) {
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        Solution sol=new Solution();
        List<List<Integer>> ans=sol.Traverse(root);
        System.out.println(ans);
        }
}

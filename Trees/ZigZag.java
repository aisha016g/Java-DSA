import java.util.*;
class node {
    int data;
    node left;
    node right;
node(int val){
    data=val;
    left=right=null;
}
}
class Sol{
    public List<List<Integer>> spiral(node root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<node> q=new LinkedList<>();
        q.offer(root);
        boolean LtoR=true;
        while(!q.isEmpty()){
            int size=q.size();
            Integer[] level = new Integer[size];
            for(int i=0;i<size;i++){
                node curr = q.poll();
                if(LtoR){
                    level[i]=curr.data;
                } else {
                    level[size-1-i]=curr.data;
                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            res.add(Arrays.asList(level));
            LtoR = !LtoR;
        }
        return res;
    }
}
public class ZigZag {
    public static void main(String[] args) {
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        Sol ans=new Sol();
        List<List<Integer>> res=new ArrayList<>();
        res=ans.spiral(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}

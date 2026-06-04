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
    long idx;
    node Node;
Pair(long idx,node Node){
    this.idx=idx;
    this.Node=Node;
}
}
class Solution{
    public int width(node root){
        if (root==null) return 0;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,root));

        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();

            long minIdx =q.peek().idx;
            long first=0,last=0;

            for(int i=0;i<size;i++){

                Pair curr=q.poll();

                long currIdx= curr.idx - minIdx;

                if(i==0) first = currIdx;
                if(i==size-1) last = currIdx;
                if(curr.Node.left!=null)
                q.add(new Pair(2*currIdx+1,curr.Node.left));
                
                if(curr.Node.right!=null)
                q.add(new Pair(2*currIdx+2,curr.Node.right));
            }
             
             ans=Math.max(ans,(int)(last-first+1));
        }
        return ans;
    }

}
public class MaxWidth {
    public static void main(String[] args) {
     node root=new node(1);
     root.left=new node(2);
     root.right=new node(3);
     root.left.left=new node(4);
     root.right.right=new node(5);
    
     Solution sol=new Solution();
     System.out.println(sol.width(root));

     
    }   
    
}

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

class Solution{
    public List<Integer> View(node root){
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<=size-1;i++){
                node curr=q.remove();
                if(i==size-1)
                {
                    ans.add(curr.data);
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return ans;
    }
}
public class Right_View {
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

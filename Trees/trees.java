import java.util.*;
class node{
    int data;
    node left;
    node right;
node(int val){
    data = val;
    left = right =null;
}
}
class Sol{
    public List<List<Integer>> brute(node root){
        List<List<Integer>> ls=new ArrayList<>();
        if(root==null) return ls;
        Queue<node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level= new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                node Node=q.poll();
                level.add(Node.data);
                if(Node.left!=null)
                    q.add(Node.left);
                if(Node.right!=null)
                    q.add(Node.right);
            }
            ls.add(level);
        }
        return ls;
    } 
    public int height(node root){
        if(root==null) return 0;
        int lt= height(root.left);
        int rt= height(root.right);
        return 1+Math.max(lt,rt);
    }
}
public class trees {
    public static void main(String[] args) {
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node (5);
        Sol ans=new Sol();
        // List<List<Integer>> result =ans.brute(root);
        // for (List<Integer> level : result) {
        //     System.out.println(level);
        // }
        System.out.println(ans.height(root));
    }
}

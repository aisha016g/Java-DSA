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
    private boolean getPath(node root,int x,List<Integer> arr){
        if(root==null) return false;
        arr.add(root.data);
        if(root.data==x) return true;
        if(getPath(root.left,x,arr) || getPath(root.right,x,arr))
            return true;
        arr.remove(arr.size()-1);
        return false;
    }
    public List<Integer> path(node root, int x){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        getPath(root,x,ans);
        return ans;

    }
}

public class RootToNode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
     node root=new node(1);
     root.left=new node(2);
     root.right=new node(3);
     root.left.left=new node(4);
     root.left.right=new node(5);
     root.left.right.left=new node(6);
     root.left.right.right=new node(7);
     int x=sc.nextInt();
     Solution sol=new Solution();
     List<Integer> ans=sol.path(root,x);
     System.out.println(ans);
     sc.close();
    }    
}

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
class traverse{
    public boolean isLeaf(node root){
        if(root!=null && root.left== null && root.right==null)
            return true;
        return false;
    }
    public void addLeaves(node root,List<Integer> list){
        if(root==null) return ;
        if(isLeaf(root)==true){
            list.add(root.data);
            return ;
        }
        addLeaves(root.left,list);
        addLeaves(root.right,list);
    }
    public void RightBoundary(node root,List<Integer>list){
        List<Integer> temp=new ArrayList<>();
        node curr=root.right;
        while(curr!=null){
        if(isLeaf(curr)==false)
            temp.add(curr.data);
        if(curr.right!=null) curr=curr.right;
        else
            curr=curr.left;
    }
        for(int i=temp.size()-1 ;i>=0;i--)
        {
            list.add(temp.get(i));
        }
    }
    public void LeftBoundary(node root,List<Integer>list){
        node curr=root.left;
       while(curr!=null)
        {
            if(isLeaf(curr)==false)
            { 
                list.add(curr.data);
            }
            if(curr.left!=null) 
                curr=curr.left;
            else
                curr=curr.right;
        }
    }
    public List<Integer> boundary(node root){
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        // add root
        if(isLeaf(root)==false) list.add(root.data);
        // check left side
        LeftBoundary(root, list);
        // adding leaf nodes 
        addLeaves(root, list);
        // adding right side of tree
        RightBoundary(root, list);
        return list;
    }
}
public class boundayTraversal {
    public static void main(String[] args) {
     node root=new node(1);
     root.left=new node(2);
     root.right=new node(3);
     root.left.left=new node(4);   
     root.left.right=new node(5); 
     traverse sol=new traverse();
     List<Integer> ans=new ArrayList<>();
     ans=sol.boundary(root);
     for(int i:ans){
        System.out.print(i+" ");
     }  
    }
}

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class BSTIterator {
    Stack<Node> st = new Stack<>();

    public BSTIterator(Node root) {
        pushAllLeft(root);
    }

    private void pushAllLeft(Node node) {
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        Node curr = st.pop();
        if(curr.right != null)
            pushAllLeft(curr.right);

        return curr.data;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

public class BSTiterator {

    public static void main(String[] args) {

        /*
                7
              /   \
             3     15
                  /  \
                 9    20
        */

        Node root = new Node(7);

        root.left = new Node(3);

        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);

        BSTIterator it = new BSTIterator(root);

        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
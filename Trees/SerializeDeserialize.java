import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    // Serialize
    public String serialize(Node root) {

        if (root == null)
            return "";

        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr == null) {
                res.append("n ");
                continue;
            }

            res.append(curr.data).append(" ");

            q.add(curr.left);
            q.add(curr.right);
        }

        return res.toString();
    }

    // Deserialize
    public Node deserialize(String data) {

        if (data.equals(""))
            return null;

        String[] values = data.split(" ");

        Node root = new Node(Integer.parseInt(values[0]));

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < values.length; i++) {

            Node parent = q.poll();

            // Left child
            if (!values[i].equals("n")) {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }

            // Right child
            i++;

            if (i < values.length && !values[i].equals("n")) {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }

    // Inorder Traversal
    public void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class SerializeDeserialize {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);

        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        Solution obj = new Solution();

        // Serialize
        String serialized = obj.serialize(root);

        System.out.println("Serialized Tree:");
        System.out.println(serialized);

        // Deserialize
        Node newRoot = obj.deserialize(serialized);

        System.out.println("\nInorder Traversal After Deserialization:");
        obj.inorder(newRoot);
    }
}
import java.util.*;

class node {
    int data;
    node left;
    node right;

    node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    public HashMap<node, node> bfsParent(node root) {
        Queue<node> q = new LinkedList<>();
        HashMap<node, node> parentMap = new HashMap<>();

        q.add(root);

        while (!q.isEmpty()) {

            node curr = q.remove();

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        return parentMap;
    }

    public List<Integer> distanceK(node root, node target, int k) {

        HashMap<node, node> parentMap = bfsParent(root);

        Queue<node> q = new LinkedList<>();
        HashSet<node> vis = new HashSet<>();

        q.add(target);
        vis.add(target);

        int dist = 0;

        while (!q.isEmpty()) {

            if (dist == k)
                break;

            int size = q.size();

            for (int i = 0; i < size; i++) {

                node curr = q.remove();

                // left child
                if (curr.left != null && !vis.contains(curr.left)) {
                    vis.add(curr.left);
                    q.add(curr.left);
                }

                // right child
                if (curr.right != null && !vis.contains(curr.right)) {
                    vis.add(curr.right);
                    q.add(curr.right);
                }

                // parent
                node parent = parentMap.get(curr);

                if (parent != null && !vis.contains(parent)) {
                    vis.add(parent);
                    q.add(parent);
                }
            }

            dist++;
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.remove().data);
        }

        return ans;
    }
}

public class TargetNode {
    public static void main(String[] args) {

        node root = new node(3);

        root.left = new node(5);
        root.right = new node(1);

        root.left.left = new node(6);
        root.left.right = new node(2);

        root.right.left = new node(0);
        root.right.right = new node(8);

        root.left.right.left = new node(7);
        root.left.right.right = new node(4);

        Solution obj = new Solution();

        node target = root.left; // node 5
        int k = 2;
        List<Integer> ans = obj.distanceK(root, target, k);

        System.out.println(ans);
    }
}
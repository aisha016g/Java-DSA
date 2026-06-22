import java.util.*;

class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {

    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();

        vis[start] = true;
        q.offer(new Pair(start, -1));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int node = curr.node;
            int parent = curr.parent;

            for (int neigh : adj.get(node)) {

                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.offer(new Pair(neigh, node));
                }
                else if (neigh != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfs(i, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class CycleUndirectedBFS {
    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

        Solution obj = new Solution();

        System.out.println(obj.isCycle(adj, V));
    }
}
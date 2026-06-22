import java.util.*;

class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {

        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       int[] vis, int[] pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {

            // If node is not visited
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis)) {
                    return true;
                }
            }

            // If node is already in current DFS path
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0; // backtracking
        return false;
    }
}

public class DirectedCycleDFS {

    public static void main(String[] args) {

        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        // 0 -> 1
        // 1 -> 2
        // 2 -> 3
        // 3 -> 1 (cycle)

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Solution obj = new Solution();

        if (obj.isCycle(adj, V)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }
    }
}
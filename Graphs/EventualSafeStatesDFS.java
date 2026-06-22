import java.util.*;

class Solution {

    public boolean dfs(int node,
                       ArrayList<ArrayList<Integer>> adj,
                       int[] check,
                       int[] vis,
                       int[] pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {

            if (vis[it] == 0) {

                if (dfs(it, adj, check, vis, pathVis)) {
                    return true;
                }
            }
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        check[node] = 1;      // Safe node
        pathVis[node] = 0;    // Backtracking

        return false;
    }

    public List<Integer> safeNodes(ArrayList<ArrayList<Integer>> adj, int V) {

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, check, vis, pathVis);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}

public class EventualSafeStatesDFS {

    public static void main(String[] args) {

        int V = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(5);

        adj.get(3).add(0);

        adj.get(4).add(5);

        // 5 and 6 have no outgoing edges

        Solution obj = new Solution();

        List<Integer> ans = obj.safeNodes(adj, V);

        System.out.println(ans);
    }
}
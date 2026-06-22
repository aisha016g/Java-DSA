import java.util.*;

class Solution {
    public List<Integer> Topo(ArrayList<ArrayList<Integer>> adj, int V) {

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                dfs(i, adj, vis, st);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }

    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,Stack<Integer> st) {

        vis[node] = 1;

        for(int it : adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adj, vis, st);
            }
        }

        st.push(node);
    }
}

public class TopologicalDFS {

    public static void main(String[] args) {

        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Solution obj = new Solution();

        List<Integer> topo = obj.Topo(adj, V);

        System.out.println(topo);
    }
}
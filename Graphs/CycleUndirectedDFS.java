import java.util.*;
class Solution {

    public boolean dfs(int start, int parent,ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[start] = true;

        for(int neigh: adj.get(start)){
            if(!vis[neigh]){
                if(dfs(neigh, start, adj, vis))
                return true;
            }
            if(vis[neigh] == true && neigh!= parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i,-1, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class CycleUndirectedDFS {
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
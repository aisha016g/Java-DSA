package Graphs;
import java.util.*;

class Solution{
    public static void dfs(int node, boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ls ){
        vis[node] = true;
        ls.add(node);
        for(Integer i: adj.get(node)){
            if(vis[i] == false){
                dfs(i, vis,adj, ls);
            }
        }
    }

    public ArrayList<Integer> dfsGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V+1];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }
}
public class DFS {
    public static void main(String[] args) {

        int V = 5;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        // 0 -> 1,2
        // 1 -> 0,3,4
        // 2 -> 0
        // 3 -> 1
        // 4 -> 1

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(0);

        adj.get(3).add(1);

        adj.get(4).add(1);

        Solution obj = new Solution();

        ArrayList<Integer> result = obj.dfsGraph(V, adj);

        System.out.println("BFS Traversal:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}

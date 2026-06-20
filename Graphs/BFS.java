package Graphs;

import java.util.*;

class Solution {
    public ArrayList<Integer> bfsGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer i : adj.get(node)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }

        return bfs;
    }
}

public class BFS {
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

        ArrayList<Integer> result = obj.bfsGraph(V, adj);

        System.out.println("BFS Traversal:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
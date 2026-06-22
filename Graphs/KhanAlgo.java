// Kahn's Algorithm (BFS Topological Sort)
// Works only for Directed Acyclic Graphs (DAG)

import java.util.*;

class Solution {

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        // Step 1: Calculate indegree of every node
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 2: Push all nodes having indegree 0 into queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Stores the topological ordering
        int[] topo = new int[V];
        int index = 0;

        // Step 3: BFS Traversal
        while (!q.isEmpty()) {

            int node = q.poll();

            // Add current node to answer
            topo[index++] = node;

            // Remove outgoing edges from current node
            for (int it : adj.get(node)) {

                indegree[it]--;

                // If indegree becomes 0,
                // it is ready to be processed
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return topo;
    }
}

public class KhanAlgo {

    public static void main(String[] args) {

        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        // 5 -> 2
        // 5 -> 0
        // 4 -> 0
        // 4 -> 1
        // 2 -> 3
        // 3 -> 1

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Solution obj = new Solution();

        int[] ans = obj.topoSort(V, adj);

        System.out.println("Topological Order:");

        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}
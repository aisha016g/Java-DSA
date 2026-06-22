// Detect Cycle in Directed Graph using Kahn's Algorithm (BFS)

import java.util.*;

class Solution {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        // Step 1: Calculate indegree of every node
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 2: Push all nodes having indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        // Step 3: Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            count++;

            for (int it : adj.get(node)) {

                indegree[it]--;

                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        // If all nodes are processed
        // then graph is acyclic
        if (count == V) {
            return false; // No Cycle
        }

        return true; // Cycle Exists
    }
}

public class DetectCycleDirection {

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
        // 3 -> 1

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Solution obj = new Solution();

        if (obj.isCycle(V, adj)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }
    }
}
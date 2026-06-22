import java.util.*;

class Solution {

    // Function to check if graph is Bipartite
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int V) {

        // Stores color of each vertex
        // -1 = not colored
        // 0 and 1 are the two colors
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {

            // If node is not colored, start BFS
            if (color[i] == -1) {
                if (!check(i, adj, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    // BFS function
    public boolean check(int start, ArrayList<ArrayList<Integer>> adj,
                         int[] color) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        // Assign first color
        color[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            // Visit all neighbours
            for (int neigh : adj.get(node)) {

                // If neighbour is not colored
                if (color[neigh] == -1) {

                    // Assign opposite color
                    color[neigh] = 1 - color[node];

                    q.offer(neigh);
                }

                // If neighbour has same color
                else if (color[neigh] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class BipartiteBFS {

    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        /*
                0 ----- 1
                |       |
                |       |
                3 ----- 2

            This graph is Bipartite
        */

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

        Solution obj = new Solution();

        if (obj.isBipartite(adj, V)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is NOT Bipartite");
        }
    }
}
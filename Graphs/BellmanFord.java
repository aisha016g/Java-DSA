//detect negative cycles only in Directed Graph
// and change undirected graph to undirected graph 
import java.util.*;

class Solution {
    public int[] bellman(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e8));
        dist[S] = 0;

        // 1. Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // 2. Nth relaxation to detect negative cycles
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                // Negative cycle detected
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }
}

public class BellmanFord {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Number of vertices
        int V = 4; 
        int source = 0;

        // --- CASE 1: DIRECTED GRAPH ---
        ArrayList<ArrayList<Integer>> directedEdges = new ArrayList<>();
        directedEdges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        directedEdges.add(new ArrayList<>(Arrays.asList(1, 2, -2))); // negative edge, but no cycle
        directedEdges.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
        directedEdges.add(new ArrayList<>(Arrays.asList(3, 1, -2))); // This creates a negative cycle: 1 -> 2 -> 3 -> 1 (total weight = -1)

        System.out.println("--- Testing Directed Graph with Negative Cycle ---");
        int[] resultDirected = solver.bellman(V, directedEdges, source);
        printResult(resultDirected);


        // --- CASE 2: UNDIRECTED GRAPH ---
        // To handle an undirected graph, we manually add bidirectional edges.
        ArrayList<ArrayList<Integer>> undirectedEdges = new ArrayList<>();
        
        // Representing an undirected edge between 0 and 1 with weight 4
        addEdgeUndirected(undirectedEdges, 0, 1, 4);
        // Representing an undirected edge between 1 and 2 with weight 3
        addEdgeUndirected(undirectedEdges, 1, 2, 3);
        // Representing an undirected edge between 2 Modeling 3 with weight 2
        addEdgeUndirected(undirectedEdges, 2, 3, 2);

        System.out.println("\n--- Testing Safe Undirected Graph ---");
        int[] resultUndirected = solver.bellman(V, undirectedEdges, source);
        printResult(resultUndirected);
    }

    // Helper method to convert an undirected edge into two directed edges
    private static void addEdgeUndirected(ArrayList<ArrayList<Integer>> edges, int u, int v, int wt) {
        edges.add(new ArrayList<>(Arrays.asList(u, v, wt)));
        edges.add(new ArrayList<>(Arrays.asList(v, u, wt)));
    }

    // Helper method to print outputs
    private static void printResult(int[] dist) {
        if (dist.length == 1 && dist[0] == -1) {
            System.out.println("Negative cycle detected! Shortest distances cannot be calculated.");
        } else {
            System.out.println("Shortest distances from source:");
            for (int i = 0; i < dist.length; i++) {
                System.out.println("Node " + i + " -> " + dist[i]);
            }
        }
    }
}
/*
        Topological Sort using Kahn's Algorithm (in-degree method) for a Directed Acyclic Graph (DAG):
        ✅ How it works:

Compute the in-degree for all vertices.

Add vertices with in-degree 0 to a queue.

Remove vertices from the queue one by one, reduce the in-degree of their neighbors, and add new vertices with in-degree 0 to the queue.

If all vertices are processed, we get a valid topological order.

If not all vertices are processed, the graph has a cycle.

Example Output:
Topological Order: [4, 5, 0, 2, 3, 1]
*/

import java.util.*;

public class TopologicalSortKahn {

    // Function to perform topological sort using Kahn's algorithm
    public static List<Integer> topologicalSort(int vertices, List<List<Integer>> adj) {
        int[] inDegree = new int[vertices];  // Array to store in-degrees of all vertices

        // Calculate in-degree for each vertex
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue to store vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoOrder.add(current);

            // Reduce in-degree of neighboring vertices
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check for cycle
        if (topoOrder.size() != vertices) {
            System.out.println("Graph has a cycle! Topological sort not possible.");
            return new ArrayList<>();
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        int vertices = 6;

        // Adjacency list representation of DAG
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Example edges
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> topoOrder = topologicalSort(vertices, adj);

        System.out.println("Topological Order: " + topoOrder);
    }
}

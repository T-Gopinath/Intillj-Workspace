import java.util.*;

/*
    ✅ Approach
    Serialization

    Convert the adjacency list into a string format like:

    A:B,C;B:C,D;C:;D:A;

    Format rule:
    node:neighbor1,neighbor2,...;

    Deserialization

    Parse the string back and reconstruct a Map<String, List<String>> graph

 */

//✅ Java Program: Serialize & Deserialize Graph

public class GraphSerializer {

    // Serialize adjacency list to string
    public static String serialize(Map<String, List<String>> graph) {
        StringBuilder sb = new StringBuilder();

        for (String node : graph.keySet()) {
            sb.append(node).append(":");

            List<String> neighbors = graph.get(node);
            if (neighbors != null && !neighbors.isEmpty()) {
                sb.append(String.join(",", neighbors));
            }

            sb.append(";"); // end of one node block
        }
        return sb.toString();
    }

    // Deserialize string to adjacency list
    public static Map<String, List<String>> deserialize(String data) {
        Map<String, List<String>> graph = new HashMap<>();
        if (data == null || data.isEmpty()) return graph;

        String[] entries = data.split(";");

        for (String entry : entries) {
            if (entry.isEmpty()) continue;

            String[] parts = entry.split(":");
            String node = parts[0];

            graph.putIfAbsent(node, new ArrayList<>());

            if (parts.length > 1 && !parts[1].isEmpty()) {
                String[] neighbors = parts[1].split(",");
                graph.get(node).addAll(Arrays.asList(neighbors));
            }
        }

        return graph;
    }

    public static void main(String[] args) {

        // Example graph
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("C", "D"));
        graph.put("C", Collections.emptyList());
        graph.put("D", Arrays.asList("A"));

        System.out.println("Original Graph: " + graph);

        // Serialize
        String serialized = serialize(graph);
        System.out.println("Serialized: " + serialized);

        // Deserialize
        Map<String, List<String>> restored = deserialize(serialized);
        System.out.println("Deserialized Graph: " + restored);
    }
}

/*
    ✅ Sample Output
        Original Graph: {A=[B, C], B=[C, D], C=[], D=[A]}
        Serialized: A:B,C;B:C,D;C:;D:A;
        Deserialized Graph: {A=[B, C], B=[C, D], C=[], D=[A]}
 */
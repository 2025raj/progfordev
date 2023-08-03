// question 3b

import java.util.Arrays;

public class BellmanFordAlgorithm {

    // Nested class representing an edge in the graph.
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    // Method to find the shortest distances using Bellman-Ford algorithm.
    static void bellmanFord(int[] distance, Edge[] edges, int vertices, int source) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

     // Relaxation step - iterate (vertices - 1) times to ensure shortest distances.
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Graph contains negative cycle");
                return;
            }
        }

        // Print shortest distances from source
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        int[] distance = new int[vertices];
        Edge[] edges = {
            new Edge(0, 1, -1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 3),
            new Edge(1, 3, 2),
            new Edge(1, 4, 2),
            new Edge(3, 2, 5),
            new Edge(3, 1, 1),
            new Edge(4, 3, -3)
        };

        int source = 0;
        bellmanFord(distance, edges, vertices, source);
    }
}

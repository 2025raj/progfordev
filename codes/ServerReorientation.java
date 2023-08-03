import java.util.*;

public class ServerReorientation {
    public static int minEdgesChanged(int n, int[][] connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph[from].add(to); // Create a directed graph.
        }

        int[] changesNeeded = new int[n];
        dfs(0, -1, graph, changesNeeded);

        int minEdgesChanged = 0;
        for (int changes : changesNeeded) {
            minEdgesChanged += changes;
        }

        return minEdgesChanged;
    }

    private static void dfs(int current, int parent, List<Integer>[] graph, int[] changesNeeded) {
        for (int child : graph[current]) {
            if (child == parent) continue;
            dfs(child, current, graph, changesNeeded);
            changesNeeded[current] += changesNeeded[child];
        }

        if (current != 0 && graph[current].size() == 1) {
            changesNeeded[current] = 1;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };

        int minEdgesChanged = minEdgesChanged(n, connections);
        System.out.println("Minimum number of edges to be changed: " + minEdgesChanged);
    }
}

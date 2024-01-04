import java.util.*;

public class MaxFlow {
    private int node;
    private LinkedList<int[]>[] graph;

    public MaxFlow(int node) {
        this.node = node;
        graph = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public void addWeightedEdge(int source, int destination, int weight) {
        int[] edge = { destination, weight };
        int[] reverseEdge = { source, 0 }; // Weight of the reverse edge is set to 0
        graph[source].add(edge);
        graph[destination].add(reverseEdge);
    }

    private boolean bfs(int source, int sink, int[] parent) {
        boolean[] visited = new boolean[node];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int capacity = edge[1];
                if (!visited[v] && capacity > 0) {
                    queue.offer(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return visited[sink];
    }

    public int findMaxFlow(int source, int sink) {
        int[] parent = new int[node];
        int MaxFlow = 0;

        while (bfs(source, sink, parent)) {
            int pathMaxFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                for (int[] edge : graph[u]) {
                    if (edge[0] == v) {
                        pathMaxFlow = Math.min(pathMaxFlow, edge[1]);
                        break;
                    }
                }
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                for (int[] edge : graph[u]) {
                    if (edge[0] == v) {
                        edge[1] -= pathMaxFlow;
                        for (int[] revEdge : graph[v]) {
                            if (revEdge[0] == u) {
                                revEdge[1] += pathMaxFlow;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            MaxFlow += pathMaxFlow;
        }
        return MaxFlow;
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        MaxFlow graph = new MaxFlow(V);

        // Adding edges to the graph (sample edges)
        graph.addWeightedEdge(0, 1, 12);
        graph.addWeightedEdge(0, 2, 14);
        graph.addWeightedEdge(1, 2, 1);
        graph.addWeightedEdge(1, 3, 12);
        graph.addWeightedEdge(2, 1, 4);
        graph.addWeightedEdge(2, 4, 14);
        graph.addWeightedEdge(3, 2, 9);
        graph.addWeightedEdge(3, 5, 20);
        graph.addWeightedEdge(4, 3, 7);
        graph.addWeightedEdge(4, 5, 4);

        int source = 0;
        int destination = 5;

        // Calculate max MaxFlow
        int MaxFlow = graph.findMaxFlow(source, destination);
        System.out.println("The maximum possible MaxFlow is " + MaxFlow);
    }
}

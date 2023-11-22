import java.util.*;
@SuppressWarnings("unchecked")

class BellmanFordShortestPath {
    int V;
    LinkedList<int[]>[] adjacencyList;

    public BellmanFordShortestPath(int V) {
        this.V = V;
        adjacencyList = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addWeightedEdge(int source, int dest, int weight) {
        int[] edge = { dest, weight };
        adjacencyList[source].add(edge);
        System.out.println("Added a weighted edge between " + source + " & " + dest + " having weight: " + weight);
    }

    void BellmanFord(int src) {
        int[] dist = new int[V];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; ++i) {
            for (int j = 0; j < V; ++j) {
                for (int[] edge : adjacencyList[j]) {
                    int v = edge[0];
                    int weight = edge[1];
                    if (dist[j] != Integer.MAX_VALUE && dist[j] + weight < dist[v]) {
                        dist[v] = dist[j] + weight;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < V; ++j) {
            for (int[] edge : adjacencyList[j]) {
                int v = edge[0];
                int weight = edge[1];
                if (dist[j] != Integer.MAX_VALUE && dist[j] + weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        printArr(dist);
    }

    void printArr(int[] dist) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        BellmanFordShortestPath  graph = new BellmanFordShortestPath(V);
        graph.addWeightedEdge(0, 1, -1);
        graph.addWeightedEdge(0, 2, 4);
        graph.addWeightedEdge(1, 3, 2);
        graph.addWeightedEdge(1, 2, 3);
        graph.addWeightedEdge(1, 4, 2);
        graph.addWeightedEdge(3, 2, 5);
        graph.addWeightedEdge(3, 1, 1);
        graph.addWeightedEdge(4, 3, -3);

        int source = 0;
        graph.BellmanFord(source);
    }
}

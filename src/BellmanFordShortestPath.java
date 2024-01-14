import java.util.*;
import Utility.CustomLinkedList;
@SuppressWarnings("unchecked")

class BellmanFordShortestPath {
    int vertex;
    int[] parent;
    CustomLinkedList<int[]>[] adjacencyList;

    public BellmanFordShortestPath(int vertex) {
        this.vertex = vertex;
        adjacencyList = new CustomLinkedList[vertex];
        for (int i = 0; i < vertex; ++i) {
            adjacencyList[i] = new CustomLinkedList<>();
        }
    }

    public void addWeightedEdge(int source, int dest, int weight) {
        int[] edge = { dest, weight };
        adjacencyList[source].addLast(edge);  // Use addLast to add the edge to the list
        System.out.println("Added a weighted edge between " + source + " & " + dest + " having weight: " + weight);
    }

    void BellmanFord(int src) {
        int[] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        for (int i = 0; i < vertex - 1; ++i) {
            for (int j = 0; j < vertex; ++j) {
                int finalJ = j;
                adjacencyList[j].forEach(edge -> {
                    int vertex = edge[0];
                    int weight = edge[1];
                    if (dist[finalJ] != Integer.MAX_VALUE && dist[finalJ] + weight < dist[vertex]) {
                        dist[vertex] = dist[finalJ] + weight;
                    }
                });
            }
        }

        for (int j = 0; j < vertex; ++j) {
            int finalJ = j;
            adjacencyList[j].forEach(edge -> {
                int vertex = edge[0];
                int weight = edge[1];
                if (dist[finalJ] != Integer.MAX_VALUE && dist[finalJ] + weight < dist[vertex]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            });
        }

        printArr(dist);
    }

    void printArr(int[] dist)

    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertex; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }


    private int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]); // Path compression
        }
        return parent[vertex];
    }



    public static void main(String[] args) {
        int V = 5;
        BellmanFordShortestPath graph = new BellmanFordShortestPath(V);
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

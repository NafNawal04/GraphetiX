import java.util.*;
import Utility.CustomLinkedList;
@SuppressWarnings("unchecked")

class BellmanFordShortestPath {
    int vertex;
    int[] parent;
    CustomLinkedList<int[]>[] adjacencyList;

    public BellmanFordShortestPath(CustomLinkedList<int[]>[] GraphRepresentationList) {
        this.adjacencyList = GraphRepresentationList;
        vertex = GraphRepresentationList.length;
        int source = 0;
        BellmanFord(source);

    }

//    public void addWeightedEdge(int source, int dest, int weight) {
//        int[] edge = { dest, weight };
//        adjacencyList[source].addLast(edge);  // Use addLast to add the edge to the list
//        System.out.println("Added a weighted edge between " + source + " & " + dest + " having weight: " + weight);
//    }

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




}

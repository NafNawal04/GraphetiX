import Utility.CustomLInkedList;
import java.util.Scanner;
public class bellmanfordshortestpath {
    public  int node;
    public int num_of_new_nodes;
    public CustomLInkedList<int[]>[] GraphRepresentationList;

    public bellmanfordshortestpath(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLInkedList[node];
        for (int i = 0; i < node; i++) {
            GraphRepresentationList[i] = new CustomLInkedList<>();
        }
    }
    public void bellmanFord(int src) {
        int[] dist = new int[node];

        for (int i = 0; i < node; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i = 1; i < node; ++i) {
            for (int j = 0; j < GraphRepresentationList.length; ++j) {
                for (int k = 0; k < GraphRepresentationList[j].length(); k++) {
                    int[] edge = GraphRepresentationList[j].get(k);
                    int v = edge[0];
                    int weight = edge[1];
                    if (dist[j] != Integer.MAX_VALUE && dist[j] + weight < dist[v])
                        dist[v] = dist[j] + weight;
                }
            }
        }

        for (int j = 0; j < GraphRepresentationList.length; ++j) {
            for (int k = 0; k < GraphRepresentationList[j].length(); k++) {
                int[] edge = GraphRepresentationList[j].get(k);
                int v = edge[0];
                int weight = edge[1];
                if (dist[j] != Integer.MAX_VALUE && dist[j] + weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < node; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        bellmanfordshortestpath graph = new bellmanfordshortestpath(V);

        // ... add edges ...

        System.out.print("Enter the source vertex: ");
        int sourceVertex = scanner.nextInt();

        graph.bellmanFord(sourceVertex);

        scanner.close();
    }
}

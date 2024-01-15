package NewPackage;
import Utility.*;
import java.util.Scanner;

public class MaxFlow {
    private final int node;

    private CustomLinkedList<int[]>[] graph;

    public MaxFlow(int node) {
        this.node = node;
        graph = new CustomLinkedList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new CustomLinkedList<>();
        }
    }

    public void addWeightedEdge(int source, int destination, int weight) {
        int[] edge = { destination, weight };
        int[] reverseEdge = { source, 0 };
        graph[source].addLast(edge);
        graph[destination].addLast(reverseEdge);
    }



    private boolean bfs(int source, int sink, int[] parent) {
        boolean[] visited = new boolean[node];
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.offer(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.pollQueue();

            graph[u].forEach(edge -> {
                int v = edge[0];
                int capacity = edge[1];
                if (!visited[v] &&capacity > 0) {
                    queue.offer(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            });
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
                final int[] minFlow = {pathMaxFlow};
                int finalV = v;
                graph[u].forEach(edge -> {
                    if (edge[0] == finalV) {
                        minFlow[0] = Math.min(minFlow[0], edge[1]);
                    }
                });

                pathMaxFlow = minFlow[0];
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];

                int finalPathMaxFlow = pathMaxFlow;
                int finalV = v;
                graph[u].forEach(edge -> {
                    if (edge[0] == finalV) {
                        edge[1] -= finalPathMaxFlow;
                    }
                });

                int finalPathMaxFlow1 = pathMaxFlow;
                graph[v].forEach(revEdge -> {
                    if (revEdge[0] == u) {
                        revEdge[1] += finalPathMaxFlow1;
                    }
                });
            }

            MaxFlow += pathMaxFlow;
        }

        return MaxFlow;
    }

    public static void main(String[] args) {
        int V = 6;
        MaxFlow graph = new MaxFlow(V);


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
        System.out.print("Enter the source node: ");
        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();


        System.out.print("Enter the destination node: ");
        int destination = scanner.nextInt();



        int MaxFlow = graph.findMaxFlow( source, destination);
        System.out.println("The maximum possible MaxFlow is " + MaxFlow);
    }
}

import Utility.*;
import java.util.Scanner;
import java.util.Comparator;
@SuppressWarnings("unchecked")

public class DijkstraShortestPath {

    public int node;
    public int source;
    public CustomLinkedList<int[]>[] GraphRepresentationList;

    public DijkstraShortestPath(int node) {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];
        for (int i = 0; i < node; i++) {
            GraphRepresentationList[i] = new CustomLinkedList<>();
        }
    }
    public DijkstraShortestPath() {

    }

    public void addWeightedEdge(int source, int destination, int weight) {
        int[] edge = { destination, weight };
        int[] edge2 = { source, weight };
        GraphRepresentationList[source].addLast(edge);
        GraphRepresentationList[destination].addLast(edge2);
    }

    public CustomLinkedList<Integer> findShortestPath(int source, int destination) {
        int[] dist = new int[node];
        int[] parent = new int[node];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        CustomPriorityQueue<int[]> minHeap = new CustomPriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        minHeap.add(new int[]{source, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int u = current[0];

            if (current[1] > dist[u]) {
                continue;
            }

            GraphRepresentationList[u].forEach(neighbor -> {
                int v = neighbor[0];
                int alt = dist[u] + neighbor[1];
                if (alt < dist[v]) {
                    dist[v] = alt;
                    parent[v] = u;
                    minHeap.add(new int[]{v, alt});
                }
            });
        }

        CustomLinkedList<Integer> shortestPath = new CustomLinkedList<>();
        buildPath(shortestPath, parent, destination);
        return shortestPath;
    }

    private void buildPath(CustomLinkedList<Integer> path, int[] parent, int current) {
        // Base case to stop recursion when the source node is reached
        if (current == source) {
            path.addLast(current);
            return;
        }

        // Recursive call with the parent of the current node
        if (current >= 0 && parent[current] != -1) {
            buildPath(path, parent, parent[current]);
        }

        // Add the current node to the path after unwinding the recursion
        path.addLast(current);
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        Scanner scanner = new Scanner(System.in);
        DijkstraShortestPath graph = new DijkstraShortestPath(V);


        graph.addWeightedEdge(0, 1, 1);
        graph.addWeightedEdge( 0,2, 3);
        graph.addWeightedEdge(0, 3, 6);
        graph.addWeightedEdge(1, 4, 1);
        graph.addWeightedEdge(1, 2, 2);
        graph.addWeightedEdge(2, 3, 1);
        graph.addWeightedEdge(3, 5, 3);
        graph.addWeightedEdge(4, 0, 4);

        System.out.print("Enter the source node: ");
        int source = scanner.nextInt();

        System.out.print("Enter the destination node: ");
        int destination = scanner.nextInt();
        CustomLinkedList<Integer> shortestPath = graph.findShortestPath(source, destination);
        System.out.println("Shortest Path from node " + source + " to node " + destination + ": " + shortestPath);

        int shortestDistance = shortestPath.length() > 1 ? shortestPath.get(shortestPath.length() - 2) : 0;
        System.out.println("Shortest Distance from node " + source + " to node " + destination + " is " + shortestDistance);


    }
}

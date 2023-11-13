import java.util.*;


public class Shortestpath {
    
    private int node;
    private LinkedList<int[]>[] adjacencyList;

    public Shortestpath(int node) {
        this.node = node;
        adjacencyList = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addWeightedEdge(int source, int destination, int weight) {
        int[] edge = { destination, weight };
        int[] edge2 = { source, weight };
        adjacencyList[source].add(edge);
        adjacencyList[destination].add(edge2);
    }

    public List<Integer> findShortestPath(int source, int destination) {
        int[] dist = new int[node];
        int[] parent = new int[node];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[source] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        minHeap.add(new int[]{source, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int u = current[0];

            if (current[1] > dist[u]) {
                continue;
            }

            for (int[] neighbor : adjacencyList[u]) {
                int v = neighbor[0];
                int alt = dist[u] + neighbor[1];
                if (alt < dist[v]) {
                    dist[v] = alt;
                    parent[v] = u;
                    minHeap.add(new int[]{v, alt});
                }
            }
        }

        List<Integer> shortestPath = new ArrayList<>();
        int current = destination;
        while (current != source) {
            shortestPath.add(current);
            current = parent[current];
        }
        shortestPath.add(source);
        Collections.reverse(shortestPath);

        return shortestPath;
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        Scanner scanner = new Scanner(System.in);
        Shortestpath graph = new Shortestpath(V);


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
        List<Integer> shortestPath = graph.findShortestPath(source, destination);
        System.out.println("Shortest Path from node " + source + " to node " + destination + ": " + shortestPath);

        int shortestDistance = shortestPath.size() > 1 ? shortestPath.get(shortestPath.size() - 2) : 0;
        System.out.println("Shortest Distance from node " + source + " to node " + destination + " is " + shortestDistance);


    }
}

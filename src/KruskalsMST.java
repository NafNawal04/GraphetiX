import java.util.*;

public class KruskalsMST  {
    public int node;
    public LinkedList<int[]>[] GraphRepresentationList;
    int[] parent;

    public KruskalsMST(int node) {
        this.node = node;
        GraphRepresentationList = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            GraphRepresentationList[i] = new LinkedList<>();
        }
        parent = new int[node];
        for (int i = 0; i < node; i++) {
            parent[i] = i; // Initially, each node is its own parent
        }
    }

    public void addWeightedEdge(int source, int dest, int weight) {
        int[] edge = { dest, weight };
        int[] edge2 = { source, weight };
        GraphRepresentationList[source].add(edge);
        GraphRepresentationList[dest].add(edge2);
        System.out.println("Added a weighted edge between " + source + " & " + dest + " having weight: " + weight);
    }

    // Kruskal's Algorithm
    public List<int[]> kruskalsMST() {
        List<int[]> resultMST = new ArrayList<>();
        List<int[]> allEdges = new ArrayList<>();

        // Collect all edges from the graph representation
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < GraphRepresentationList[i].size(); j++) {
                int[] edge = GraphRepresentationList[i].get(j);
                if (i < edge[0]) { // To avoid adding edges twice (undirected graph)
                    allEdges.add(new int[] { i, edge[0], edge[1] });
                }
            }
        }

        // Sorting edges based on weights
        allEdges.sort(Comparator.comparingInt(edge -> edge[2]));

        int edgesCount = 0;
        int index = 0;

        // Applying  Kruskal's Algorithm
        while (edgesCount < node - 1 && index < allEdges.size()) {
            int[] nextEdge = allEdges.get(index++);
            int rootX = find(nextEdge[0]);
            int rootY = find(nextEdge[1]);

            if (rootX != rootY) {
                resultMST.add(nextEdge);
                union(rootX, rootY);
                edgesCount++;
            }
        }

        return resultMST;
    }

    private int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]); // Path compression
        }
        return parent[vertex];
    }

    private void union(int x, int y) {
        parent[y] = x;
    }
    public static void main(String[] args) {
        // Create a weighted graph with 4 nodes
        KruskalsMST weightedGraph = new KruskalsMST(6);

        // Add weighted edges
        weightedGraph.addWeightedEdge(0, 2, 8);
        weightedGraph.addWeightedEdge(0, 1, 7);
        weightedGraph.addWeightedEdge(1, 3, 6);
        weightedGraph.addWeightedEdge(1, 5, 5);
        weightedGraph.addWeightedEdge(2, 3, 4);
        weightedGraph.addWeightedEdge(2, 5, 3);
        weightedGraph.addWeightedEdge(1, 2, 3);
        weightedGraph.addWeightedEdge(5, 3, 2);
        weightedGraph.addWeightedEdge(4, 5, 2);



        List<int[]> minimumSpanningTree = weightedGraph.kruskalsMST();
        int min_cost=0;
        // Display the edges in the Minimum Spanning Tree
        System.out.println("Edges in the Minimum Spanning Tree (MST):");
        for (int[] edge : minimumSpanningTree) {
            System.out.println("Edge: " + edge[0] + " - " + edge[1] + " | Weight: " + edge[2]);
            min_cost+=edge[2];
        }
        System.out.println("Tota Cost of MST:" + min_cost);
    }
}

// Other methods...


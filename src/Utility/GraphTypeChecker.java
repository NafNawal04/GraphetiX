package Utility;

import java.util.*;

public class GraphTypeChecker {
    private final List<List<Integer>> adjacencyList;
    private final boolean[] visited;
    private final boolean[] recStack;
    private final int vertices;
    private int totalEdges;
    private boolean isSimple;
    private boolean isDirected;

    public GraphTypeChecker(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {

            this.adjacencyList.add(new LinkedList<>());
        }
        this.visited = new boolean[vertices];
        this.recStack = new boolean[vertices];
        this.isSimple = true;
        this.isDirected = false;
        this.totalEdges = 0;
    }

    public void addEdge(int from, int to) {
        if (from == to || adjacencyList.get(from).contains(to)) {
            isSimple = false;
            return;
        }

        if (!adjacencyList.get(to).contains(from)) {
            isDirected = true;
        }
        adjacencyList.get(from).add(to);
        if (from < to) {
            totalEdges++;
        }
    }
    public void checkDirected() {
        for (int from = 0; from < vertices; from++) {
            for (int to : adjacencyList.get(from)) {
                if (from != to && !adjacencyList.get(to).contains(from)) {
                    isDirected = true;
                    return;
                }
            }
        }
        isDirected = false;
    }

    public boolean isCyclic() {
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int node) {
        if (recStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor] && isCyclicUtil(neighbor)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

    public boolean isConnected() {
        Arrays.fill(visited, false);
        dfs(0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int neighbor : adjacencyList.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
    public boolean isTree() {
        return !isCyclic() && isConnected() && totalEdges == vertices - 1;
    }

    public boolean isComplete() {
        checkDirected();
        if( !isDirected && isSimple )
            return totalEdges == vertices * (vertices - 1) / 2;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        GraphTypeChecker graph = new GraphTypeChecker(vertices);

        System.out.println("Enter the connections for each vertex:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Connections for vertex " + i + " (end with -1): ");
            while (true) {
                int connection = scanner.nextInt();
                if (connection == -1) {
                    break;
                }
                if (connection < 0 || connection >= vertices) {
                    System.out.println("Invalid input: Vertex " + connection + " does not exist. Try again.");
                    continue;
                }
                graph.addEdge(i, connection);
            }
        }


        System.out.println("Based on the input:");
        if (vertices == 1) {
            System.out.println("The graph is Trivially Connected (only one vertex).");
        } else if (graph.isConnected()) {
            System.out.println("The graph is Connected.");
        } else {
            System.out.println("The graph is Disconnected.");
        }

        if (graph.isSimple) {
            System.out.println("The graph is Simple.");
        }

        if (graph.isTree()) {
            System.out.println("The graph is a Tree.");
        } else {
            System.out.println("The graph is not a Tree.");
        }

        if (graph.isCyclic()) {
            System.out.println("The graph is Cyclic.");
        } else {
            System.out.println("The graph is Acyclic.");
        }

        if (graph.isComplete()) {
            System.out.println("The graph is a Complete Graph.");
        }


        if (graph.isDirected) {
            System.out.println("The graph is Directed.");
        } else {
            System.out.println("The graph is Undirected.");
        }
    }
}



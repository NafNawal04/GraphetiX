package Utility;

import java.util.*;

public class GraphTypeChecker {
    private static List<Set<Integer>> adjacencyList;
    private static boolean[] visited;
    private static boolean[] recStack;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new HashSet<>());
        }

        System.out.println("Enter the connections for each vertex:");
        boolean isSimple = true;
        boolean isDirected = false;
        int totalEdges = 0;

        for (int i = 0; i < vertices; i++) {
            System.out.print("Connections for vertex " + i + " (end with -1): ");
            boolean isConnectedVertex=false ;
            while (true) {
                int connection = scanner.nextInt();
                if (connection == -1) {
                    break;
                }
                if (connection < 0 || connection >= vertices) {
                    System.out.println("Invalid input: Vertex " + connection + " does not exist. Try again.");
                    continue;
                }
                if (connection == i || adjacencyList.get(i).contains(connection)) {
                    isSimple = false; // Self-loop or multiple edge detected
                }
                if (!adjacencyList.get(connection).contains(i)) {
                    isDirected = true;
                }
                adjacencyList.get(i).add(connection);
                totalEdges++;
                isConnectedVertex = true;
            }
            if (!isConnectedVertex) {
                isSimple = false; // Vertex with no connections
            }
        }

        visited = new boolean[vertices];
        recStack = new boolean[vertices];
        boolean isCyclic = false;
        boolean isConnected = isConnected();




        boolean isTree = !isCyclic && isConnected() && totalEdges == vertices - 1;
        boolean isComplete = totalEdges == vertices * (vertices - 1);
        boolean isDisconnected = vertices > 1 && !isConnected;

        System.out.println("Based on the input:");
        if (vertices == 1) {
            System.out.println("The graph is Trivially Connected (only one vertex).");
        }
        else if (isConnected) {
            System.out.println("The graph is Connected.");
        }
        else if (isDisconnected) {
            System.out.println("The graph is Disconnected.");
        }

        if (isSimple) {
            System.out.println("The graph is Simple.");
        }

        if (isTree) {
            System.out.println("The graph is a Tree.");
        }else {
            System.out.println("The graph is not a Tree.");}
        if (isCyclic()) {
            System.out.println("The graph is Cyclic.");
        } else {
            System.out.println("The graph is Acyclic.");
        }
        if (isComplete) {
            System.out.println("The graph is a Complete Graph.");
        }
        if (isDirected) {
            System.out.println("The graph is Directed.");
        } else {
            System.out.println("The graph is Undirected.");
        }
    }

    private static boolean isCyclic() {
        // Reset visited and recStack for fresh DFS traversal
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(int node) {
        if (recStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recStack[node] = true;

        for (Integer neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor] && isCyclicUtil(neighbor)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

    private static boolean isConnected() {
        if (adjacencyList.isEmpty() || adjacencyList.size() == 1) {
            return true; // Trivially connected or no vertex
        }

        // Run DFS from a vertex that has connections
        boolean foundConnectedVertex = false;
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!adjacencyList.get(i).isEmpty()) {
                dfs(i);
                foundConnectedVertex = true;
                break;
            }
        }

        if (!foundConnectedVertex) {
            return false; // No connected vertices found
        }

        // Check if all vertices are visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int neighbor : adjacencyList.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}


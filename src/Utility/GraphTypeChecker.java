package Utility;

import java.util.*;

public class GraphTypeChecker {
    private List<List<Integer>> adjacencyList;
    private boolean[] visited;
    private boolean[] recStack;
    private int vertices;
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
            isSimple = false; // Self-loop or multiple edge detected
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
}


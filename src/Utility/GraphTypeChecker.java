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
}


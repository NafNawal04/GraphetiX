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
}


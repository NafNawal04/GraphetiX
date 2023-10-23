
import java.util.*;

public class AcyclicGraph implements IRepresentGraph,ICyclic,IAddEdge {
    public  int node;
    public  List<List<Integer>> adjacencyList;

    public AcyclicGraph(int node) {
        this.node = node;
        adjacencyList = new ArrayList<>(node);
        for (int i = 0; i < node; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }



    public boolean isCyclic() {
        boolean[] visited = new boolean[node];
        boolean[] stack = new boolean[node];

        for (int i = 0; i < node; i++) {
            if (!visited[i] && isCyclicUtil(i, visited, stack)) {
                return false; // If a cycle is found, the graph is not acyclic
            }
        }

        return true; // If no cycle is found, the graph is acyclic
    }

    public boolean isCyclicUtil(int node, boolean[] visited, boolean[] stack) {
        visited[node] = true;
        stack[node] = true;

        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, stack)) {
                    return true; // If a cycle is found in the subtree, return true
                }
            } else if (stack[neighbor]) {
                return true; // If the neighbor is in the stack, a cycle is found
            }
        }

        stack[node] = false; // Remove the node from the current path
        return false;
    }

    public void convertToCyclic() {
        if (!isCyclic()) {
            System.out.println("The graph is already cyclic.");
            return;
        }

        // Find two nodes without an edge between them and add an edge to make it cyclic
        for (int i = 0; i < node; i++) {
            for (int j = i + 1; j < node; j++) {
                if (!adjacencyList.get(i).contains(j) && !adjacencyList.get(j).contains(i)) {
                    System.out.println("Adding edge between " + i + " and " + j + " to make the graph cyclic.");
                    addEdge(i, j);
                    return;
                }
            }
        }
    }

    public void GraphRepresentation(){
        for (int i = 0; i < node; i++) {
            System.out.println("Vertex " + i + " is connected to: " + adjacencyList.get(i));
        }
    }



}

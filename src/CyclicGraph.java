import java.util.*;

public class CyclicGraph implements IRepresentGraph,ICyclic,IAddEdge{
    public  int node;
    public List<List<Integer>> adjacencyList;

    public CyclicGraph(int node) {
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
                return true;
            }
        }

        return false;
    }

    public boolean isCyclicUtil(int node, boolean[] visited, boolean[] stack) {
        visited[node] = true;
        stack[node] = true;

        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, stack)) {
                    return true;
                }
            } else if (stack[neighbor]) {
                // If the neighbor is visited ,and it is in the stack, it's part of a cycle
                return true;
            }
        }

        stack[node] = false; // Remove the vertex from the current path
        return false;
    }
    public void GraphRepresentation() {
        for (int i = 0; i < node; i++) {
            System.out.println("Vertex " + i + " is connected to: " + adjacencyList.get(i));
        }
    }



}

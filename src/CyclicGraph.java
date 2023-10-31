import java.util.*;


public class CyclicGraph implements IRepresentGraph,ICyclic,IAddEdge{
    public  int node;
    public LinkedList<Integer>[] adjacencyList ;

    public CyclicGraph(int node) {
        this.node = node;
        adjacencyList = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
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

        for (int neighbor : adjacencyList[node]) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, stack)) {
                    return true;
                }
            } else if (stack[neighbor]) {

                return true;
            }
        }

        stack[node] = false;
        return false;
    }
    public void GraphRepresentation() {
        for (int i = 0; i < node; i++) {
            System.out.println("Vertex " + i + " is connected to: " + adjacencyList[i]);
        }
    }



}

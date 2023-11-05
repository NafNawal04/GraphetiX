import libraryFunctions.*;


public class CyclicGraph
{
    public  int node;
    public Glist<Integer>[] adjacencyList ;

    public CyclicGraph(int node)
    {
        this.node = node;
        adjacencyList = new Glist[node];
        for (int i = 0; i < node; i++) {
            adjacencyList[i] = new Glist<>();
        }
    }

    public void addEdge(int source, int destination)
    {
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

        for (int j = 0; j < adjacencyList[node].length(); j++) {
            int neighbor = adjacencyList[node].get(j);
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

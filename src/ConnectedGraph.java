import java.util.*;

public class ConnectedGraph {
    int vertices;
    int AddToIndex;

    public LinkedList<Integer> adjacencyList [];
    public ConnectedGraph(int vertices)
    {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices ; i++)
        {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addVertex(int AddToIndex) {
        int newVertexIndex = vertices;
        vertices++;

        LinkedList<Integer> newVertexList = new LinkedList<>();
        adjacencyList[newVertexIndex] = newVertexList;


        addEdge(newVertexIndex,AddToIndex );
    }
    public void addEdge(int source, int dest)
    {
        adjacencyList[source].add(dest);
        adjacencyList[dest].add(source);
    }
}

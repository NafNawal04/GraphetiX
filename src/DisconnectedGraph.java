import java.util.*;

public class DisconnectedGraph {
    int vertices;
    int AddToIndex;

    public LinkedList<Integer> adjacencyList [];
    public DisconnectedGraph(int vertices)
    {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices ; i++)
        {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addVertex() {
        int newVertexIndex = vertices;
        vertices++;

        LinkedList<Integer> newVertexList = new LinkedList<>();
        adjacencyList[newVertexIndex] = newVertexList;



    }
    public void addEdge(int source, int dest)
    {
        adjacencyList[source].add(dest);
        adjacencyList[dest].add(source);
    }
}


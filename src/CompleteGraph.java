import java.util.*;

public class CompleteGraph {

    public ArrayList<ArrayList<Integer>> AdjacencyMatrix;
    int vertices;

    public CompleteGraph(int vertices)
    {
        AdjacencyMatrix = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            AdjacencyMatrix.add(new ArrayList<>());
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                addEdge(i, j);
            }
        }

    }
    public void addEdge( int s, int d) {
        AdjacencyMatrix.get(s).add(d);
        AdjacencyMatrix.get(d).add(s);
    }
    public void addVertex()
    {

        int newVertexIndex = AdjacencyMatrix.size();
        AdjacencyMatrix.add(new ArrayList<>());

        for (int i = 0; i < newVertexIndex; i++) {
            addEdge(i, newVertexIndex);
        }
    }
}

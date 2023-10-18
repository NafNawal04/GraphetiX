import java.util.*;

public class CompleteGraph {

    public LinkedList<Integer>[] AdjacencyMatrix;
    LinkedList<Integer> deletedIndex = new LinkedList<>();

    int vertices;

    public CompleteGraph(int vertices)
    {
        this.vertices = vertices;
        AdjacencyMatrix = new LinkedList[vertices];

        for (int i = 0; i < vertices ; i++)
        {
            AdjacencyMatrix [i] = new LinkedList<>();
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                AdjacencyMatrix[i].add(j);
                AdjacencyMatrix[j].add(i);
            }
        }

    }

    public void addVertex()
    {

        int newVertexIndex = vertices;
        int num_of_new_nodes =  vertices + 1;
        LinkedList<Integer>[] newGraphRepresentList = new LinkedList[num_of_new_nodes];

        for(int i = 0; i < vertices; i++)
        {
            newGraphRepresentList[i] = AdjacencyMatrix[i];
        }

        for (int i = vertices; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new LinkedList<>();
        }

        vertices = num_of_new_nodes;
        AdjacencyMatrix = newGraphRepresentList;

        for (int i = 0; i < newVertexIndex ; i++) {
            if(!deletedIndex.contains(i))
          {
                AdjacencyMatrix[i].add(newVertexIndex);
                AdjacencyMatrix[newVertexIndex].add(i);
            }
        }

    }
    public void removeVertex(int deleteIndex)
    {
        deletedIndex.add(deleteIndex);

        AdjacencyMatrix[deleteIndex].clear();

        for (int i=0;i<vertices;i++)
        {
            AdjacencyMatrix[i].remove(Integer.valueOf(deleteIndex));
        }
        System.out.println(" after removing vertex "+ deleteIndex + " the connected graph becomes:");
        GraphRepresentation();

    }
    public void GraphRepresentation()
    {
        for (LinkedList<Integer> list : AdjacencyMatrix)
        {
            Collections.sort(list);
        }

        System.out.println("Adjacency Matrix for complete graph:");
        for (int i = 0; i < AdjacencyMatrix.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + AdjacencyMatrix[i]);
        }

    }
}

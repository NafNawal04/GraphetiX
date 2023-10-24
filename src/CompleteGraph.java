import libraryFunctions.Glist;



public class CompleteGraph implements IAddVertex,IRemoveNode,IRepresentGraph {

    public Glist<Integer> AdjacencyMatrix [];
    Glist<Integer> deletedIndex = new Glist<>();

    int vertices;

    public CompleteGraph(int vertices)
    {
        this.vertices = vertices;
        AdjacencyMatrix = new Glist[vertices];

        for (int i = 0; i < vertices ; i++)
        {
            AdjacencyMatrix [i] = new Glist<>();
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
        Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_nodes];
        for(int i = 0; i < vertices; i++)
        {
            newGraphRepresentList[i] = AdjacencyMatrix[i];
        }
        for (int i = vertices; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new Glist<>();
        }

        vertices = num_of_new_nodes;
        AdjacencyMatrix = newGraphRepresentList;

        for (int i = 0; i < newVertexIndex ; i++) {

            if(!AdjacencyMatrix[i].isEmpty() ) {
                AdjacencyMatrix[i].add(newVertexIndex);
                AdjacencyMatrix[newVertexIndex].add(i);
            }
        }

    }




    public void removeNode(int deleteIndex)
    {
        deletedIndex.add(deleteIndex);

        AdjacencyMatrix[deleteIndex].clear();

        for (int i=0;i<vertices;i++)
        {
            AdjacencyMatrix[i].removeValue(deleteIndex);
        }
        System.out.println(" after removing vertex "+ deleteIndex + " the complete graph becomes:");
        GraphRepresentation();

    }
    public void GraphRepresentation()
    {
        for (int i=0;i<AdjacencyMatrix.length;i++)
        {
            AdjacencyMatrix[i].sort();
        }

        System.out.println("Adjacency Matrix for complete graph:");
        for (int i = 0; i < AdjacencyMatrix.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + AdjacencyMatrix[i]);
        }

    }
}


import libraryFunctions.Glist;

public class ConnectedGraph implements IRemoveNode,IAddEdge,IGraph,IRepresentGraph{
    int vertices;
    Glist<Integer> deletedIndex = new Glist<>();

    public Glist<Integer> adjacencyList [];
    public ConnectedGraph(int vertices)
    {
        this.vertices = vertices;
        adjacencyList = new Glist[vertices];

        for (int i = 0; i < vertices ; i++)
        {
            adjacencyList[i] = new Glist<>();
        }
        for (int i = 0; i < vertices-1 ; i++) {
            adjacencyList[i].add(i+1);
            adjacencyList[i+1].add(i);
        }

    }
    public void removeNode(int deleteIndex)
    {
        deletedIndex.add(deleteIndex);

        adjacencyList[deleteIndex].clear();

        for (int i=0;i<vertices;i++)
        {
            adjacencyList[i].removeValue(deleteIndex);
        }
        System.out.println(" after removing vertex "+ deleteIndex + " the connected graph becomes:");
        GraphRepresentation();


    }
    public void removeEdge(int source,int destination)
    {
        //need to implement some conditions to check whether it becomes disconnected or not
        //multiedge or not?
        adjacencyList[source].removeValue(destination);
        adjacencyList[destination].removeValue(source);
    }
    public void addNewNode(int AddToIndex)
    {
        if(deletedIndex.contains( AddToIndex) ) {
            System.out.println("vertex doesn't exist");
        }
        else {
            int newVertexIndex = vertices;
            int num_of_new_nodes =  vertices + 1;
            Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_nodes];

            for(int i = 0; i < vertices; i++)
            {
                newGraphRepresentList[i] = adjacencyList[i];
            }

            for (int i = vertices; i < num_of_new_nodes; i++)
            {
                newGraphRepresentList[i] = new Glist<>();
            }

            vertices = num_of_new_nodes;
            adjacencyList = newGraphRepresentList;


            addEdge(newVertexIndex,AddToIndex );
        }
    }
    public void addEdge(int source, int dest)
    {
        if(deletedIndex.contains( source) ) {
            System.out.println("vertex doesn't exist");
        }
        else {
            adjacencyList[source].add(dest);
            adjacencyList[dest].add(source);
        }
    }


    public void GraphRepresentation()
    {
        for (int i=0;i<adjacencyList.length;i++)
        {
            adjacencyList[i].sort();
        }

        System.out.println("Adjacency Matrix for connected graph:");
        for (int i = 0; i < adjacencyList.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + adjacencyList[i]);
        }

    }
}

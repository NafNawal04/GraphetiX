import libraryFunctions.*;

public class DisconnectedGraph {
    int vertices;
    Glist<Integer> deletedIndex = new Glist<>();



    Glist<Integer> adjacencyList [];
    public DisconnectedGraph(int vertices)
    {
        this.vertices = vertices;
        adjacencyList = new Glist[vertices];

        for (int i = 0; i < vertices ; i++)
        {
            adjacencyList [i] = new Glist<>();
        }
    }

    public void removeVertex(int deleteIndex)
    {
        deletedIndex.add(deleteIndex);
        adjacencyList[deleteIndex].clear();

        for (int i=0;i<vertices;i++)
        {
            adjacencyList[i].removeValue(deleteIndex);
        }
        System.out.println(" after removing vertex "+ deleteIndex + " the disconnected graph becomes:");
        GraphRepresentation();

    }
    public void removeEdge(int source,int destination)
    {
        adjacencyList[source].removeValue(destination);
        adjacencyList[destination].removeValue(source);

        System.out.println("The edge is deleted");
    }
    public void addEdge(int source, int dest)
    {
        //need to implement some conditions to check whether it becomes connected or not
        //multiple edge?
        if(deletedIndex.contains( source) ) {
            System.out.println("vertex doesn't exist");
        }
        else {
            adjacencyList[source].add(dest);
            adjacencyList[dest].add(source);
        }
    }

    public void addVertex() {

        int num_of_new_vertices =  vertices + 1;
        Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_vertices];

        for (int i = 0; i < vertices; i++)
        {
            newGraphRepresentList[i] = adjacencyList[i];
        }

        for (int i = vertices; i < num_of_new_vertices; i++)
        {
            newGraphRepresentList[i] = new Glist<>();
        }

        vertices = num_of_new_vertices;
        adjacencyList = newGraphRepresentList;


    }

    public void GraphRepresentation()
    {
        for (int i=0;i<adjacencyList.length;i++)
        {
            adjacencyList[i].sort();
        }

        System.out.println("Adjacency Matrix for Disconnected graph:");
        for (int i = 0; i < adjacencyList.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + adjacencyList[i]);
        }

    }
}


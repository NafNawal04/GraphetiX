import java.util.*;

public class DisconnectedGraph {
    int vertices;



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
    /* public void addVertex() {
         int newVertexIndex = vertices;
         vertices++;

         LinkedList<Integer> newVertexList = new LinkedList<>();
         adjacencyList[newVertexIndex] = newVertexList;

     }*/
    public void removeVertex(int deleteIndex)
    {

        adjacencyList[deleteIndex].clear();

        for (int i=0;i<vertices;i++)
        {
            adjacencyList[i].remove(Integer.valueOf(deleteIndex));
        }
        System.out.println(" after removing vertex "+ deleteIndex + " the disconnected graph becomes:");
        GraphRepresentation();

    }
    public void removeEdge(int source,int destination)
    {
        adjacencyList[source].remove(Integer.valueOf(destination));
        adjacencyList[destination].remove(Integer.valueOf(source));

        System.out.println("The edge is deleted");
    }
    public void addEdge(int source, int dest)
    {
        //need to implement some conditions to check whether it becomes connected or not
        //multiple edge?
        adjacencyList[source].add(dest);
        adjacencyList[dest].add(source);
    }

    public void addVertex() {

        int num_of_new_vertices =  vertices + 1;
        LinkedList<Integer>[] newGraphRepresentList = new LinkedList[num_of_new_vertices];

        for (int i = 0; i < vertices; i++)
        {
            newGraphRepresentList[i] = adjacencyList[i];
        }

        for (int i = vertices; i < num_of_new_vertices; i++)
        {
            newGraphRepresentList[i] = new LinkedList<>();
        }

        vertices = num_of_new_vertices;
        adjacencyList = newGraphRepresentList;


    }

    public void GraphRepresentation()
    {
        for (LinkedList<Integer> list : adjacencyList)
        {
            Collections.sort(list);
        }

        System.out.println("Adjacency Matrix for Disconnected graph:");
        for (int i = 0; i < adjacencyList.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + adjacencyList[i]);
        }

    }
}


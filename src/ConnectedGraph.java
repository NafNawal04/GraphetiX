import java.util.*;

public class ConnectedGraph {
    int vertices;





    public LinkedList<Integer> adjacencyList [];
    public ConnectedGraph(int vertices)
    {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices ; i++)
        {
            adjacencyList[i] = new LinkedList<>();
        }
        for (int i = 0; i < vertices-1 ; i++) {
            addEdge(i, i + 1);
        }

    }
    public void removeVertex(int deleteIndex)
    {

        adjacencyList[deleteIndex].clear();

        for (int i=0;i<vertices;i++)
        {
                adjacencyList[i].remove(Integer.valueOf(deleteIndex));
        }
        System.out.println(" after removing vertex "+ deleteIndex + " the connected graph becomes:");
        GraphRepresentation();


    }
    public void removeEdge(int source,int destination)
    {
        //need to implement some conditions to check whether it becomes disconnected or not
        //multiedge or not?
        adjacencyList[source].remove(Integer.valueOf(destination));
        adjacencyList[destination].remove(Integer.valueOf(source));
    }
    public void addVertex(int AddToIndex)
    {
        int newVertexIndex = vertices;
        int num_of_new_nodes =  vertices + 1;
        LinkedList<Integer>[] newGraphRepresentList = new LinkedList[num_of_new_nodes];

        for(int i = 0; i < vertices; i++)
        {
            newGraphRepresentList[i] = adjacencyList[i];
        }

        for (int i = vertices; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new LinkedList<>();
        }

        vertices = num_of_new_nodes;
        adjacencyList = newGraphRepresentList;

        addEdge(newVertexIndex,AddToIndex );
    }
    public void addEdge(int source, int dest)
    {

        adjacencyList[source].add(dest);
        adjacencyList[dest].add(source);
    }


    public void GraphRepresentation()
    {
        for (LinkedList<Integer> list : adjacencyList)
        {
            Collections.sort(list);
        }

        System.out.println("Adjacency Matrix for connected graph:");
        for (int i = 0; i < adjacencyList.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + adjacencyList[i]);
        }

    }
}

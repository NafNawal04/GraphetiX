import libraryFunctions.Glist;
public class UndirectedGraph implements IRepresentGraph,IGraph,IRemoveNode,IAddEdge
{
    int node;
    int num_of_new_nodes;
    public Glist<Integer>[] GraphRepresentList;

    public UndirectedGraph(int node)
    {
        this.node = node;
        GraphRepresentList = new Glist[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentList[i] = new Glist<>();
            i++;
        }
    }
    public void addEdge(int source, int dest)
    {
        if(source == dest)
        {
            GraphRepresentList[source].add(dest);
        }
        else
        {
            GraphRepresentList[source].add(dest);
            GraphRepresentList[dest].add(source);
        }
    }

    public void addNewNode(int n)
    {
        num_of_new_nodes = node + n;
        Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_nodes];

        for (int i = 0; i < node; i++)
        {
            newGraphRepresentList[i] = GraphRepresentList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new Glist<>();
        }

        node = num_of_new_nodes;
        GraphRepresentList = newGraphRepresentList;

    }

    public void removeEdge(int source,int dest)
    {
        if(source == dest)
        {
            GraphRepresentList[source].removeValue(dest);
        }
        else
        {
            GraphRepresentList[dest].removeValue(source);
            GraphRepresentList[source].removeValue(dest);
        }
        System.out.println("\nAfter removing the edge between " + source + " & " + dest +" the undirected graph would be:");
        GraphRepresentation();
    }

    public void removeNode(int node_num)
    {
        GraphRepresentList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            while(GraphRepresentList[i].contains(node_num))
            {
                GraphRepresentList[i].removeValue(node_num);
            }

        }
        System.out.println("After removing vertex "+ node_num + ", the undirected graph becomes:");
        GraphRepresentation();

    }
    public void convertToDirected(int source, int dest)
    {
        System.out.println("\nAfter making the edge between " + source + " & " + dest +" as directed, the graph would be:");
        GraphRepresentList[dest].removeValue(source);
        GraphRepresentation();

    }

    public void GraphRepresentation()
    {

        for (int i=0;i<node;i++)
        {
            GraphRepresentList[i].sort();
        }
        for (int i = 0; i <  GraphRepresentList.length; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentList[i]);
        }

    }


}

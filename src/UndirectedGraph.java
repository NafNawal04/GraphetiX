import libraryFunctions.Glist;
public class UndirectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    public Glist<Integer>[] GraphRepresentationList;

    public UndirectedGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new Glist[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentationList[i] = new Glist<>();
            i++;
        }
    }
    @Override
    public void addEdge(int source, int dest)
    {
        if(source == dest)
        {
            GraphRepresentationList[source].add(dest);
        }
        else
        {
            GraphRepresentationList[source].add(dest);
            GraphRepresentationList[dest].add(source);
        }
    }
    @Override
    public void addNode(int node_num)
    {
        num_of_new_nodes = node + node_num;
        Glist<Integer>[] newGraphRepresentationList = new Glist[num_of_new_nodes];

        for (int i = 0; i < node; i++)
        {
            newGraphRepresentationList[i] = GraphRepresentationList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentationList[i] = new Glist<>();
        }

        node = num_of_new_nodes;
        GraphRepresentationList = newGraphRepresentationList;

    }
    @Override
    public void removeEdge(int source,int dest)
    {
        if(source == dest)
        {
            GraphRepresentationList[source].removeValue(dest);
        }
        else
        {
            GraphRepresentationList[dest].removeValue(source);
            GraphRepresentationList[source].removeValue(dest);
        }
        System.out.println("\nAfter removing the edge between " + source + " & " + dest +" the undirected graph would be:");
        GraphRepresentation();
    }
    @Override
    public void removeNode(int node_num)
    {
        GraphRepresentationList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            while(GraphRepresentationList[i].contains(node_num))
            {
                GraphRepresentationList[i].removeValue(node_num);
            }

        }
        System.out.println("After removing vertex "+ node_num + ", the undirected graph becomes:");
        GraphRepresentation();

    }
    public void convertToDirected(int source, int dest)
    {
        System.out.println("\nAfter making the edge between " + source + " & " + dest +" as directed, the graph would be:");
        GraphRepresentationList[dest].removeValue(source);
        GraphRepresentation();

    }
    @Override
    public void GraphRepresentation()
    {
        for (int i = 0; i <  GraphRepresentationList.length; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
        }

    }


}

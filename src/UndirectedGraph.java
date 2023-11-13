import Utility.CustomLInkedList;
import Utility.GraphMethod;
import Utility.GraphTraversal;

public class UndirectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    public CustomLInkedList<Integer>[] GraphRepresentationList;

    public UndirectedGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLInkedList[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentationList[i] = new CustomLInkedList<>();
            i++;
        }
    }
    @Override
    public void addEdge(int source, int dest)
    {
        if(source == dest)
        {
            GraphRepresentationList[source].addFIrst(dest);
            System.out.println("Added an edge between " + source + " & " + dest);
        }
        else
        {
            GraphMethod g =new GraphMethod(GraphRepresentationList);
            g.addEdge(source,dest);
        }

    }
    @Override
    public void addNode(int node_num)
    {
        num_of_new_nodes = node + node_num;
        CustomLInkedList<Integer>[] newGraphRepresentationList = new CustomLInkedList[num_of_new_nodes];

        for (int i = 0; i < node; i++)
        {
            newGraphRepresentationList[i] = GraphRepresentationList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentationList[i] = new CustomLInkedList<>();
        }

        node = num_of_new_nodes;
        GraphRepresentationList = newGraphRepresentationList;
        System.out.println("Added "+ node_num+ " number of nodes in the Undirected Graph.");
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
        System.out.println("Removed the edge between " + source + " & " + dest);
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
        System.out.println("Removed the node "+ node_num + " from the simple graph.");

    }
    public void convertToDirected(int source, int dest)
    {
         GraphRepresentationList[dest].removeValue(source);
        System.out.println("Made the edge between " + source + " & " + dest +" as directed. ");


    }
    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Undirected graph:");
        for (int i = 0; i <  GraphRepresentationList.length; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
        }

    }

    void bfs(int start_node)
    {
        GraphTraversal graphTraversal=new GraphTraversal(start_node,GraphRepresentationList,node);
        graphTraversal.bfs();

    }



}

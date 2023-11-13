
import Utility.*;

public class SimpleGraph implements IGraph
{
    public int node;
    public int num_of_new_nodes;
    public CustomLInkedList<Integer>[] GraphRepresentationList ;


    public SimpleGraph(int node)
    {

        this.node=node;
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
        GraphMethod g =new GraphMethod(GraphRepresentationList);

        if(source == dest)
        {
            System.out.println("Cannot add any loop in simple graph.");
        }
        else
        {

            if(GraphRepresentationList[source].contains(dest)||GraphRepresentationList[dest].contains(source) )
            {
                System.out.println("Cannot add multi edges between two same nodes in simple graph");
            }

            else
            {
               g.addEdge(source,dest);
            }
        }


    }
    @Override
    public void removeEdge(int source,int dest)
    {
        GraphRepresentationList[source].removeValue(dest);
        GraphRepresentationList[dest].removeValue(source);
        System.out.println("Removed the edge between " + source + " & " + dest);

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

        System.out.println("Added "+ node_num+ " number of nodes in the Simple Graph.");
    }

    @Override
    public void removeNode(int node_num)
    {
        GraphRepresentationList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue(node_num);
        }
        System.out.println("Removed the node "+ node_num + " from the simple graph.");


    }

    @Override
    public void GraphRepresentation()
    {

        System.out.println("List Representation for Simple graph:");
        for (int i = 0; i < GraphRepresentationList.length; i++)
        {
            if(!GraphRepresentationList[i].isEmpty())
            {
                System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
            }
            else
            {
                System.out.println("Vertex " + i + " is connected to: Empty List");
            }
        }

    }

    void bfs(int start_node)
    {
        GraphTraversal graphTraversal=new GraphTraversal(start_node,GraphRepresentationList,node);
        graphTraversal.bfs();

    }


}
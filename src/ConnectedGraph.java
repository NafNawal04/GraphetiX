
import Utility.CustomLInkedList;
import Utility.GraphMethod;
import Utility.GraphTraversal;

public class ConnectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    CustomLInkedList<Integer> deletedIndex = new CustomLInkedList<>();

    public CustomLInkedList<Integer> GraphRepresentationList[];
    public ConnectedGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLInkedList[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList[i] = new CustomLInkedList<>();
        }
        for (int i = 0; i < node-1 ; i++)
        {
            GraphRepresentationList[i].addFIrst(i+1);
            GraphRepresentationList[i+1].addFIrst(i);
        }

    }

    @Override
    public void addEdge(int source, int dest)
    {
        GraphMethod g =new GraphMethod(GraphRepresentationList);
        if(deletedIndex.contains(source))
        {
            System.out.println("vertex "+ source+ " doesn't exist. So no edge can be added");
        }
        else
        {
            g.addEdge(source,dest);
        }
    }
    @Override
    public void removeEdge(int source,int dest)
    {
        GraphMethod g =new GraphMethod(GraphRepresentationList);
        g.removeEdge(source, dest);

    }

    @Override
    public void addNode(int node_num)
    {
        int dummy = node;
        int num_of_new_nodes = node + node_num;
        GraphMethod g=new GraphMethod(GraphRepresentationList);


        GraphRepresentationList = g.addNode(node_num,node);
        node = num_of_new_nodes;

            for(int i= dummy-1;i<node-1;i++)
            {
                GraphRepresentationList[i].addFIrst(i+1);
                GraphRepresentationList[i+1].addFIrst(i);
            }


        System.out.println("Added "+ node_num+ " number of nodes in the Connected Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        deletedIndex.addFIrst(node_num);

        GraphRepresentationList[node_num].clear();

        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue(node_num);
        }
        GraphRepresentationList[node_num-1].addFIrst(node_num+1);
        GraphRepresentationList[node_num+1].addFIrst(node_num-1);
        System.out.println("Removed the node "+ node_num + " from the connected graph.");


    }
    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Connected graph:");
        for (int i = 0; i < GraphRepresentationList.length; i++)
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

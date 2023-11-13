import Utility.CustomLInkedList;
import Utility.GraphTraversal;

public class DirectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    public CustomLInkedList<Integer>[] GraphRepresentationList;

    public DirectedGraph(int node)
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

        GraphRepresentationList[source].addFIrst(dest);
        System.out.println("Added an edge between " + source + " & " + dest);

    }

    @Override
    public void removeEdge(int source, int dest)
    {
        GraphRepresentationList[source].removeValue(dest);
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

        System.out.println("Added "+ node_num+ " number of nodes in the Directed Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        GraphRepresentationList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue((node_num));
        }
        System.out.println("Removed the node "+ node_num + " from the simple graph.");

    }



    public void inDegree(int dest)
    {
        int count =0;
        for (CustomLInkedList<Integer> source :GraphRepresentationList)
        {
            if(source.contains(dest))
            {
                count++;
            }
        }
        System.out.println("The number of in degree of " +dest+ " is: " + count);

    }


    public void outDegree(int source)
    {

        int num = GraphRepresentationList[source].length() ;
        System.out.println("The number of out degree of " + source+ " is: " + num);
    }
    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for directed graph:");
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



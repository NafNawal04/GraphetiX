import Utility.*;

public class DisconnectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    CustomLInkedList<Integer> deletedIndex = new CustomLInkedList<>();
    CustomLInkedList<Integer> GraphRepresentationList[];
    public DisconnectedGraph(int node)
    {
        this.node= node;
        GraphRepresentationList = new CustomLInkedList[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList [i] = new CustomLInkedList<>();
        }
    }


    @Override
    public void addNode(int node_num)
    {

        int num_of_new_nodes = node + node_num;
        GraphMethod g=new GraphMethod(GraphRepresentationList);


        GraphRepresentationList = g.addNode(node_num,node);
        node = num_of_new_nodes;

        System.out.println("Added "+ node_num+ " number of nodes in the Disconnected Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        deletedIndex.addFIrst(node_num);
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the disconnected graph.");

    }
    @Override
    public void addEdge(int source, int dest)
    {
        if(deletedIndex.contains(source))
        {
            System.out.println("vertex "+ source+ " doesn't exist. So no edge can be added");
        }
        else {
            GraphMethod g =new GraphMethod(GraphRepresentationList);
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
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Disconnected graph:");
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.GraphRepresentation(node);

    }


    void bfs(int start_node)
    {
        GraphTraversal graphTraversal=new GraphTraversal(GraphRepresentationList,node);
        graphTraversal.bfs(start_node);

    }
    public void dfs(int start_node)
    {
        GraphTraversal graphTraversal=new GraphTraversal(GraphRepresentationList,node);
        graphTraversal.DFS(start_node);

    }
}


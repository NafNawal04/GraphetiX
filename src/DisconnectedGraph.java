import Utility.*;
import Graph.*;
@SuppressWarnings("unchecked")

public class DisconnectedGraph implements IGraph
{
    int node;

    CustomLinkedList<Integer> deletedIndex = new CustomLinkedList<>();
    CustomLinkedList<int[]>[] GraphRepresentationList;
    public DisconnectedGraph(int node)
    {
        this.node= node;
        GraphRepresentationList = new CustomLinkedList[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList [i] = new CustomLinkedList<>();
        }
    }


    @Override
    public void addNode(int node_num)
    {

        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.addNode(node_num,node);

        System.out.println("Added "+ node_num+ " number of nodes in the Disconnected Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        deletedIndex.addLast(node_num);
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the disconnected graph.");

    }
    @Override
    public void addWeightedEdge(int source, int dest,int weight)
    {
        if(deletedIndex.contains(source))
        {
            System.out.println("vertex "+ source+ " doesn't exist. So no edge can be added");
        }
        else {
            GraphMethod g =new GraphMethod(GraphRepresentationList);
            g.addWeightedEdge(source,dest,weight);
        }
    }
    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        GraphMethod g =new GraphMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);


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


import Utility.CustomLinkedList;
import Graph.*;
@SuppressWarnings({"unchecked","unused"})
public class UndirectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    public CustomLinkedList<int[]>[] GraphRepresentationList;

    public UndirectedGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentationList[i] = new CustomLinkedList<>();
            i++;
        }
    }
    @Override
    public void addWeightedEdge(int source, int dest,int weight)
    {
        if(source == dest)
        {
            int[] edge = {dest,0};
            GraphRepresentationList[source].addLast(edge);
            System.out.println("Added an edge between " + source + " & " + dest);
        }
        else
        {
            GraphMethod g =new GraphMethod(GraphRepresentationList);
            g.addWeightedEdge(source,dest,weight);
        }

    }
    @Override
    public void addNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        System.out.println("Added "+ node_num+ " number of nodes in the Undirected Graph.");
    }
    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        if(source == dest)
        {
            int[] edge = {dest,0};
            GraphRepresentationList[source].removeValue(edge);
            System.out.println("Removed the edge between " + source + " & " + dest);
        }
        else
        {
            GraphMethod g =new GraphMethod(GraphRepresentationList);
            g.removeWeightedEdge(source, dest,weight);

        }

    }
    @Override
    public void removeNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the simple graph.");

    }
    public void convertToDirected(int source, int dest)
    {
        int[] edge = {source,0};
        GraphRepresentationList[dest].removeValue(edge);
        System.out.println("Made the edge between " + source + " & " + dest +" as directed. ");


    }
    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Undirected graph:");
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

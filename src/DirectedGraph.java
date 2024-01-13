import Utility.CustomLinkedList;
import Graph.*;
@SuppressWarnings({"unchecked","unused"})
public class DirectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    public CustomLinkedList<int[]>[] GraphRepresentationList;

    public DirectedGraph(int node)
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
    public void addWeightedEdge(int source, int dest, int weight)
    {
        int[] edge = {dest,0};
        GraphRepresentationList[source].addLast(edge);
        System.out.println("Added an edge between " + source + " & " + dest);

    }

    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        int[] edge = {dest,0};
        GraphRepresentationList[source].removeValue(edge);
        System.out.println("Removed the edge between " + source + " & " + dest);
    }


    @Override
    public void addNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.addNode(node_num,node);

        System.out.println("Added "+ node_num+ " number of nodes in the Directed Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the directed graph.");

    }



    public void inDegree(int dest)
    {
        int count =0;
        for (CustomLinkedList<int[]> source :GraphRepresentationList)
        {
            for(int i=0;i< source.length();i++)
            {
                int[] edge = source.get(i);
                if(edge[0] == dest)
                {
                    count++;
                }
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



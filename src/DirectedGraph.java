import Utility.CustomLInkedList;
import Graph.*;

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

        GraphRepresentationList[source].addLast(dest);
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
        int num_of_new_nodes = node + node_num;
        GraphMethod g=new GraphMethod(GraphRepresentationList);


        GraphRepresentationList = g.addNode(node_num,node);
        node = num_of_new_nodes;

        System.out.println("Added "+ node_num+ " number of nodes in the Directed Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
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



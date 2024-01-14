
import Utility.*;
import Graph.*;

@SuppressWarnings("unchecked")
public class SimpleGraph implements IGraph
{
    public int node;

    public CustomLinkedList<int[]>[] GraphRepresentationList;


    public SimpleGraph(int node)
    {

        this.node=node;
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
        GraphMethod g =new GraphMethod(GraphRepresentationList);

        if(source == dest)
        {
            System.out.println("Cannot add any loop in simple graph.");
        }
        else
        {
            for(int x=0;x< GraphRepresentationList[source].length();x++)
            {
                int[] neededEdge1 = GraphRepresentationList[source].get(x);

                    if (neededEdge1[0] == dest)
                    {
                        System.out.println("Cannot add multi edges between two same nodes in simple graph");
                        return;
                    }

            }
            for(int x=0;x< GraphRepresentationList[dest].length();x++)
            {
                int[] neededEdge2 = GraphRepresentationList[source].get(x);

                if (neededEdge2[0] == source)
                {
                    System.out.println("Cannot add multi edges between two same nodes in simple graph");
                    return;
                }
            }

            g.addWeightedEdge(source, dest, weight);
        }


    }
    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        GraphMethod g =new GraphMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);


    }

    @Override
    public void addNode(int node_num)
    {

        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        System.out.println("Added "+ node_num+ " number of nodes in the Simple Graph.");
    }

    @Override
    public void removeNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the simple graph.");


    }

    @Override
    public void GraphRepresentation()
    {

        System.out.println("List Representation for Simple graph:");
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
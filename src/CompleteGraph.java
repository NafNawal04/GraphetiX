import Utility.*;
import Graph.*;

public class CompleteGraph implements IGraph
{

    int node;

    public CustomLInkedList<Integer> GraphRepresentationList[];


    public CompleteGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLInkedList[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList [i] = new CustomLInkedList<>();
        }
        for (int i = 0; i < node; i++)
        {
            for (int j = i + 1; j < node; j++)
            {
                GraphRepresentationList[i].addLast(j);
                GraphRepresentationList[j].addLast(i);
            }
        }

    }

    @Override
    public void addEdge(int source,int dest)
    {

    }
    public void removeEdge(int source,int dest)
    {

    }
    @Override
    public void addNode(int node_num)
    {
        int dummy = node;
        int num_of_new_nodes = node + node_num;
        GraphMethod g=new GraphMethod(GraphRepresentationList);


        GraphRepresentationList = g.addNode(node_num,node);
        node = num_of_new_nodes;

        for (int i = 0; i < node; i++)
        {
            if(i<dummy)
            {
                if (!GraphRepresentationList[i].isEmpty())
                {
                    for(int j=dummy;j<node;j++)
                    {
                        GraphRepresentationList[i].addLast(j);
                    }

                }
            }
            else
            {
                for(int k=0;k<dummy;k++)
                {
                    if (!GraphRepresentationList[k].isEmpty())
                    {
                            GraphRepresentationList[i].addLast(k);
                    }
                }
                for(int l=dummy;l<node;l++)
                {
                    if(i!=l)
                    {
                        GraphRepresentationList[i].addLast(l);
                    }
                }
            }
        }


        System.out.println("Added "+ node_num+ " number of nodes in the Complete Graph.");
    }



    @Override
    public void removeNode(int node_num)
    {

        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the complete graph.");

    }

    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Complete graph:");
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

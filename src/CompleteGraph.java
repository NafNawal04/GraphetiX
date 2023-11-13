import Utility.*;
public class CompleteGraph implements IGraph
{

    int node;
    int num_of_new_nodes;
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
                GraphRepresentationList[i].addFIrst(j);
                GraphRepresentationList[j].addFIrst(i);
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
                        GraphRepresentationList[i].addFIrst(j);
                    }

                }
            }
            else
            {
                for(int k=0;k<dummy;k++)
                {
                    if (!GraphRepresentationList[k].isEmpty())
                    {
                            GraphRepresentationList[i].addFIrst(k);
                    }
                }
                for(int l=dummy;l<node;l++)
                {
                    if(i!=l)
                    {
                        GraphRepresentationList[i].addFIrst(l);
                    }
                }
            }
        }


        System.out.println("Added "+ node_num+ " number of nodes in the Complete Graph.");
    }



    @Override
    public void removeNode(int node_num)
    {

        GraphRepresentationList[node_num].clear();

        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue(node_num);
        }
        System.out.println("Removed the node "+ node_num + " from the complete graph.");

    }

    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Complete graph:");
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

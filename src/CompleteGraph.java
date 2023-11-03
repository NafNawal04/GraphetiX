import libraryFunctions.Glist;
public class CompleteGraph
{

    int node;
    int num_of_new_nodes;
    public Glist<Integer> GraphRepresentationList[];

    public CompleteGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new Glist[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList [i] = new Glist<>();
        }
        for (int i = 0; i < node; i++)
        {
            for (int j = i + 1; j < node; j++)
            {
                GraphRepresentationList[i].add(j);
                GraphRepresentationList[j].add(i);
            }
        }

    }

    public void addEdge(int source,int dest)
    {

    }
    public void removeEdge(int source,int dest)
    {

    }

    public void addNode(int node_num)
    {
        int dummy = node;
        num_of_new_nodes =  node + node_num;
        Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_nodes];
        for(int i = 0; i < node; i++)
        {
            newGraphRepresentList[i] = GraphRepresentationList[i];
        }
        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new Glist<>();
        }

        node = num_of_new_nodes;
        GraphRepresentationList = newGraphRepresentList;

        for (int i = 0; i < node; i++)
        {
            if(i<dummy)
            {
                if (!GraphRepresentationList[i].isEmpty())
                {
                    for(int j=dummy;j<node;j++)
                    {
                        GraphRepresentationList[i].add(j);
                    }

                }
            }
            else
            {
                for(int k=0;k<dummy;k++)
                {
                    if (!GraphRepresentationList[k].isEmpty())
                    {
                            GraphRepresentationList[i].add(k);
                    }
                }
                for(int l=dummy;l<node;l++)
                {
                    if(i!=l)
                    {
                        GraphRepresentationList[i].add(l);
                    }
                }
            }
        }

    }




    public void removeNode(int node_num)
    {

        GraphRepresentationList[node_num].clear();

        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue(node_num);
        }
        System.out.println(" after removing vertex "+ node_num + " the complete graph becomes:");
        GraphRepresentation();

    }
    public void GraphRepresentation()
    {
        for (int i = 0; i < GraphRepresentationList.length; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
        }

    }
}

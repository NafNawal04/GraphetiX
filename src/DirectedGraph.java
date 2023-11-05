import libraryFunctions.Glist;
public class DirectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    public Glist<Integer>[] GraphRepresentationList;

    public DirectedGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new Glist[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentationList[i] = new Glist<>();
            i++;
        }
    }
    @Override
    public void addEdge(int source, int dest)
    {

        GraphRepresentationList[source].add(dest);

    }

    @Override
    public void removeEdge(int source, int dest)
    {
        GraphRepresentationList[source].removeValue(dest);
        System.out.println("After removing edge "+ source + " to " +dest +", the directed graph becomes:");
        GraphRepresentation();
    }


    @Override
    public void addNode(int node_num)
    {
        num_of_new_nodes = node + node_num;
        Glist<Integer>[] newGraphRepresentationList = new Glist[num_of_new_nodes];

        for (int i = 0; i < node; i++)
        {
            newGraphRepresentationList[i] = GraphRepresentationList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentationList[i] = new Glist<>();
        }

        node = num_of_new_nodes;
        GraphRepresentationList = newGraphRepresentationList;

    }
    @Override
    public void removeNode(int node_num)
    {
        GraphRepresentationList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue((node_num));
        }
        System.out.println("After removing vertex "+ node_num + ", the directed graph becomes:");
        GraphRepresentation();

    }



    public void inDegree(int dest)
    {
        int count =0;
        for (Glist<Integer> source :GraphRepresentationList)
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
        for (int i = 0; i < GraphRepresentationList.length; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
        }
    }


}



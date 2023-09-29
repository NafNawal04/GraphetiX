import java.util.*;
public class DirectedGraph
{
    int node;
    int num_of_new_nodes;
    public LinkedList<Integer>[] GraphRepresentList;

    public DirectedGraph(int node)
    {
        this.node = node;
        GraphRepresentList = new LinkedList[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentList[i] = new LinkedList<>();
            i++;
        }
    }
    public void addEdgeToNode(int source, int dest)
    {

        GraphRepresentList[source].add(dest);

    }

    public void addNewNode(int n)
    {
        num_of_new_nodes = node + n;
        LinkedList<Integer>[] newGraphRepresentList = new LinkedList[num_of_new_nodes];

        for (int i = 0; i < node; i++)
        {
            newGraphRepresentList[i] = GraphRepresentList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new LinkedList<>();
        }

        node = num_of_new_nodes;
        GraphRepresentList = newGraphRepresentList;

    }

    public void removeNode(int node_num)
    {
        GraphRepresentList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentList[i].remove(Integer.valueOf(node_num));
        }
        System.out.println("After removing vertex "+ node_num + ", the undirected graph becomes:");
        representGraph();

    }

    public void inDegree(int dest)
    {
        int count =0;
        for (LinkedList<Integer> source :GraphRepresentList)
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
        int num = GraphRepresentList[source].size();
        System.out.println("The number of out degree of " + source+ " is: " + num);
    }

    public void representGraph()
    {

        for (LinkedList<Integer> list : GraphRepresentList)
        {
            Collections.sort(list);
        }
        for (int i = 0; i < GraphRepresentList.length; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentList[i]);
        }

    }


}



import java.util.*;
public class UndirectedGraph
{
    int node;
    int num_of_new_nodes;
    public LinkedList<Integer>[] GraphRepresentList;

    public UndirectedGraph(int node)
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
        if(source == dest)
        {
            GraphRepresentList[source].add(dest);
        }
        else
        {
            GraphRepresentList[source].add(dest);
            GraphRepresentList[dest].add(source);
        }
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

    public void removeEdge(int source,int dest)
    {
        if(source == dest)
        {
            GraphRepresentList[source].remove(Integer.valueOf(dest));
        }
        else
        {
            GraphRepresentList[dest].remove(Integer.valueOf(source));
            GraphRepresentList[source].remove(Integer.valueOf(dest));
        }

        System.out.println("\nAfter removing the edge between " + source + " & " + dest +" the undirected graph would be:");
        representGraph();
    }

    public void removeNode(int node_num)
    {
        GraphRepresentList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            while(GraphRepresentList[i].contains(node_num))
            {
                GraphRepresentList[i].remove(Integer.valueOf(node_num));
            }

        }
        System.out.println("After removing vertex "+ node_num + ", the undirected graph becomes:");
        representGraph();

    }
    public void convertToDirected(int source, int dest)
    {
        System.out.println("\nAfter making the edge between " + source + " & " + dest +" as directed, the graph would be:");
        GraphRepresentList[dest].remove(Integer.valueOf(source));
        representGraph();

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

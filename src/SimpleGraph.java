import java.util.*;
public class SimpleGraph implements IRepresentGraph,IGraph,IRemoveNode,IAddEdge
{
    int node;
    int num_of_new_nodes;
    public LinkedList<Integer>[] GraphRepresentList ;

    public SimpleGraph(int node)
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
    public void addEdge(int source, int dest)
    {


        if(source == dest)
        {
            System.out.println("Cannot add any loop in simple graph.");
        }
        else
        {

            if(GraphRepresentList[source].contains(dest) || GraphRepresentList[dest].contains(source))
            {
                System.out.println("Cannot add multi edges between two same nodes in simple graph");
            }
            else
            {

                GraphRepresentList[source].add(dest);
                GraphRepresentList[dest].add(source);
            }
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

    public void removeNode(int node_num)
    {
        GraphRepresentList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentList[i].remove(Integer.valueOf(node_num));
        }
        System.out.println("After removing vertex "+ node_num + ", the undirected graph becomes:");
        GraphRepresentation();

    }
    public void GraphRepresentation()
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
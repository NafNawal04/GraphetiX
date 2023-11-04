import java.util.*;
import libraryFunctions.*;

public class SimpleGraph implements IGraph
{
    public int node;
    int num_of_new_nodes;
    public Glist<Integer>[] GraphRepresentList ;

    public SimpleGraph(int node)
    {

        this.node=node;
        GraphRepresentList = new Glist[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentList[i] = new Glist<>();
            i++;
        }
    }
    @Override
    public void addEdge(int source, int dest)
    {


        if(source == dest)
        {
            System.out.println("Cannot add any loop in simple graph.");
        }
        else
        {

            if(GraphRepresentList[source].contains(dest)||GraphRepresentList[dest].contains(source) )
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
    @Override
    public void removeEdge(int source,int dest)
    {
        GraphRepresentList[source].removeValue(dest);
        GraphRepresentList[dest].removeValue(source);
        System.out.println("\nAfter removing the edge between " + source + " & " + dest +" the simple graph would be:");
        GraphRepresentation();
    }

    @Override
    public void addNode(int node_num)
    {
        num_of_new_nodes = node + node_num;
        Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_nodes];
        for (int i = 0; i < node; i++)
        {
            newGraphRepresentList[i] = GraphRepresentList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new Glist<>();
        }

        node = num_of_new_nodes;
        GraphRepresentList = newGraphRepresentList;

    }

    @Override
    public void removeNode(int node_num)
    {
        GraphRepresentList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentList[i].removeValue(node_num);
        }
        System.out.println("After removing vertex "+ node_num + ", the simple graph becomes:");
        GraphRepresentation();

    }

    @Override
    public void GraphRepresentation()
    {

        for (int i = 0; i < GraphRepresentList.length; i++)
        {
            if(!GraphRepresentList[i].isEmpty())
            {
                System.out.println("Vertex " + i + " is connected to: " + GraphRepresentList[i]);
            }
            else
            {
                System.out.println("Vertex " + i + " is connected to: Empty List");
            }
        }

    }


}
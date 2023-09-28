import java.util.*;
public class SimpleGraph
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
    public void addEdgeToNode(int source, int dest)
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

    public void addNewVertex(int n)
    {
        num_of_new_nodes = node + n;
        LinkedList<Integer>[] newGraphRepresentList = new LinkedList[num_of_new_nodes]; //copy korlam arek list a notun vertex size shoho

        for (int i = 0; i < node; i++)
        {
            newGraphRepresentList[i] = GraphRepresentList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++) //notun vertex er jonno array create
        {
            newGraphRepresentList[i] = new LinkedList<>();
        }

        node = num_of_new_nodes;
        GraphRepresentList = newGraphRepresentList; //naming convension er jonno

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
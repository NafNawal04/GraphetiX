package Graph;

import Utility.CustomLInkedList;

public class GraphMethod {
    public CustomLInkedList<Integer>[] GraphRepresentationList ;
    public GraphMethod( CustomLInkedList<Integer>[] GraphRepresentationList)
    {
        this.GraphRepresentationList=GraphRepresentationList;
    }
    public void addEdge(int source, int dest)
    {


         GraphRepresentationList[source].addLast(dest);
         GraphRepresentationList[dest].addLast(source);
         System.out.println("Added an edge between " + source + " & " + dest);


    }
    public void removeEdge(int source,int dest)
    {
        GraphRepresentationList[source].removeValue(dest);
        GraphRepresentationList[dest].removeValue(source);
        System.out.println("Removed the edge between " + source + " & " + dest);

    }
    public CustomLInkedList<Integer>[] addNode(int node_num,int node)
    {
        int num_of_new_nodes = node + node_num;
        CustomLInkedList<Integer>[] newGraphRepresentationList = new CustomLInkedList[num_of_new_nodes];
        for (int i = 0; i < node; i++)
        {
            newGraphRepresentationList[i] = GraphRepresentationList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentationList[i] = new CustomLInkedList<>();
        }

        return newGraphRepresentationList;


    }
    public void removeNode(int node_num,int node) {
        GraphRepresentationList[node_num].clear();
        for (int i = 0; i < node; i++) {
            GraphRepresentationList[i].removeValue(node_num);
        }
    }
    public void GraphRepresentation(int node)
    {


        for (int i = 0; i < node; i++)
        {
            if(!GraphRepresentationList[i].isEmpty())
            {
                System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
            }
            else
            {
                System.out.println("Vertex " + i + " is connected to: Empty List");
            }
        }

    }
}

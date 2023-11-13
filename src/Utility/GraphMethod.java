package Utility;

public class GraphMethod {
    public CustomLInkedList<Integer>[] GraphRepresentationList ;
    public GraphMethod( CustomLInkedList<Integer>[] GraphRepresentationList)
    {
        this.GraphRepresentationList=GraphRepresentationList;
    }
    public void addEdge(int source, int dest)
    {


         GraphRepresentationList[source].addFIrst(dest);
         GraphRepresentationList[dest].addFIrst(source);
         System.out.println("Added an edge between " + source + " & " + dest);


    }
}

public class Main
{
    public static void main(String[] args)
    {
        CompleteGraph completeGraph = new CompleteGraph(5);

        completeGraph.removeVertex(1);
        completeGraph.removeVertex(2);
        completeGraph.addVertex();

        completeGraph.GraphRepresentation();



        ConnectedGraph c1=new ConnectedGraph(5);
//        c1.addEdge(0,1);
//        c1.addEdge(1,2);
//        c1.addEdge(2,3);
//        c1.addEdge(4,2);

        c1.removeVertex(2);
        // after deleting vertex 2,it still exists in the list,though empty.
        c1.addVertex(2);
        c1.addVertex(2);

        c1.removeEdge(2,4);


        c1.GraphRepresentation();


        DisconnectedGraph DisconnectedGraph1 =new DisconnectedGraph(4);
        DisconnectedGraph1.addEdge(0,1);
        DisconnectedGraph1.addEdge(0,3);
        DisconnectedGraph1.addEdge(2,3);
        DisconnectedGraph1.addEdge(1,3);

        DisconnectedGraph1.addVertex();
        DisconnectedGraph1.addEdge(1,4);
        DisconnectedGraph1.addVertex();

        DisconnectedGraph1.GraphRepresentation();
        DisconnectedGraph1.removeVertex(3);




        DisconnectedGraph1.GraphRepresentation();







    }
}


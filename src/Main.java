public class Main
{
    public static void main(String[] args)
    {
        CompleteGraph completeGraph = new CompleteGraph(5);
        completeGraph.addVertex();

        ConnectedGraph c1=new ConnectedGraph(5);
        c1.addEdge(0,1);
        c1.addEdge(1,2);
        c1.addEdge(2,3);
        c1.addEdge(4,2);
        // c1.addVertex(2);


        DisconnectedGraph DisconnectedGraph1 =new DisconnectedGraph(4);
        DisconnectedGraph1.addEdge(0,1);
        DisconnectedGraph1.addEdge(0,3);
        //DisconnectedGraph1.addVertex();



        System.out.println("Adjacency Matrix for complete graph:");
        for (int i = 0; i < completeGraph.AdjacencyMatrix.size(); i++)
        {
            System.out.println(completeGraph.AdjacencyMatrix.get(i));
        }
        System.out.println("Adjacency Matrix for connected graph:");
        for (int i = 0; i < c1.adjacencyList.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + c1.adjacencyList[i]);
        }
        System.out.println("Adjacency Matrix for Disconnected graph:");
        for (int i = 0; i < DisconnectedGraph1.adjacencyList.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + DisconnectedGraph1.adjacencyList[i]);
        }

    }
}


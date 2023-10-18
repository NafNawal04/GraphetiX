public class Main {
    public static void main(String[] args) {

        CompleteGraph completeGraph = new CompleteGraph(5);

        completeGraph.removeVertex(1);
        completeGraph.removeVertex(2);
        completeGraph.addVertex();

        completeGraph.GraphRepresentation();



        ConnectedGraph c1=new ConnectedGraph(5);


        c1.removeVertex(2);

        c1.addVertex(2);
        c1.addVertex(2);

        c1.addEdge(2,4);
        c1.addEdge(3,0);


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
        DisconnectedGraph1.addVertex();
        DisconnectedGraph1.addEdge(6,5);
        DisconnectedGraph1.addEdge(3,5);
        DisconnectedGraph1.addEdge(3,6);
        DisconnectedGraph1.addEdge(6,4);


        DisconnectedGraph1.GraphRepresentation();
        WeightedGraph graph = new WeightedGraph(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);

        graph.printGraph();
        System.out.println("\n");



        CyclicGraph g1 = new CyclicGraph(4);

        // Add edges to create a cyclic graph
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 1);

        if (g1.isCyclic()) {
            System.out.println("The graph contains a cycle.");
            g1.printGraph();
            System.out.println("\n");

        } else {
            System.out.println("The graph does not contain a cycle.");
            System.out.println("\n");
        }


        AcyclicGraph g2 = new AcyclicGraph(6);
        g2.addEdge(0, 1);
        g2.addEdge(1, 3);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(3, 5);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(0, 4);
        g2.addEdge(0, 5);


//        System.out.println("Original Graph:");
//        g2.printGraph();

        if (g2.isAcyclic()) {
            System.out.println("The graph is acyclic.");
            g2.convertToCyclic();
            System.out.println("Converted to Cyclic Graph:");
            g2.printGraph();
        } else {
            System.out.println("The graph is already cyclic.");
        }
//
    }
//
//
}






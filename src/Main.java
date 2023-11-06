public class Main {
    public static void main(String[] args) {

        System.out.println("\n");

        Graph s1 = new Graph("SimpleGraph", 5);
        s1.getSimple().addEdge(0, 1);
        s1.getSimple().addEdge(1, 1); //should show error
        s1.getSimple().addEdge(0, 4);
        s1.getSimple().addEdge(1, 2);
        s1.getSimple().addEdge(3, 1);
        s1.getSimple().addEdge(2, 1); //should show error
        s1.getSimple().addEdge(4, 2);
        s1.getSimple().addNode(2); //two new nodes should be added to the list
        System.out.println("List Representation for Simple graph:");
        s1.getSimple().GraphRepresentation(); // rearranges the values in ascending order and then visualizes the graph by showing the vertices one vertex is connected to in a linked list
        s1.getSimple().removeNode(2);
        s1.getSimple().removeEdge(4, 0);
        System.out.println("breadth first traversal: ");
        s1.getSimple().bfs(2);


        System.out.println("\n");
        System.out.println("\n");



        DirectedGraph d1 = new DirectedGraph(5);
        d1.addEdge(1, 1);
        d1.addEdge(0, 4);
        d1.addEdge(0, 1);
        d1.addEdge(1, 2);
        d1.addEdge(3, 1);
        d1.addEdge(2, 3);
        d1.addNode(1);
        d1.addEdge(4, 2);
        System.out.println("List Representation for Directed graph:");
        d1.GraphRepresentation();
        d1.inDegree(1);
        d1.outDegree(1);
        d1.removeNode(3);
        d1.removeEdge(4, 2);


        System.out.println("\n");
        System.out.println("\n");


        UndirectedGraph u1 = new UndirectedGraph(5);
        u1.addEdge(0, 4);
        u1.addEdge(1, 2);
        u1.addEdge(3, 4);
        u1.addEdge(2, 4);
        u1.addEdge(4, 2);
        u1.addEdge(0, 0);
        u1.addNode(0);
        System.out.println("List Representation for Undirected graph:");
        u1.GraphRepresentation();
        u1.convertToDirected(1, 2);
        u1.removeEdge(0, 4);
        u1.removeNode(4);


        CompleteGraph completeGraph = new CompleteGraph(5);
        System.out.println("List Representation for Complete graph:");
        completeGraph.GraphRepresentation();

        completeGraph.removeNode(1);
        completeGraph.removeNode(2);

        completeGraph.addNode(3);
        System.out.println("List Representation for Complete graph after adding node:");
        completeGraph.GraphRepresentation();


        ConnectedGraph c1 = new ConnectedGraph(5);
        System.out.println("List representation for connected graph:");
        c1.GraphRepresentation();

        c1.removeNode(2);
        c1.addNode(2);
        System.out.println("After adding and removing nodes, List representation for connected graph:");
        c1.GraphRepresentation();
        c1.addEdge(2, 4);
        c1.addEdge(3, 0);
        c1.removeEdge(2, 4);
        System.out.println("After adding and removing edges, List representation for connected graph:");
        c1.GraphRepresentation();



        DisconnectedGraph dc1 = new DisconnectedGraph(4);
        dc1.addEdge(0, 1);
        dc1.addEdge(0, 3);
        dc1.addEdge(2, 3);
        dc1.addEdge(1, 3);

        dc1.addNode(1);
        dc1.addEdge(1, 4);
        dc1.addNode(1);

        System.out.println("List Representation for Disconnected graph:");
        dc1.GraphRepresentation();
        dc1.removeNode(3);
        dc1.addNode(1);
        dc1.addEdge(6, 5);
        dc1.addEdge(3, 5);
        dc1.addEdge(3, 6);
        dc1.addEdge(6, 4);

        System.out.println("List Representation for Disconnected graph:");
        dc1.GraphRepresentation();


        WeightedGraph graph = new WeightedGraph(6);

        graph.addWeightedEdge(0, 1, 4);
        graph.addWeightedEdge(0, 2, 3);
        graph.addWeightedEdge(1, 3, 2);
        graph.addWeightedEdge(1, 2, 5);
        graph.addWeightedEdge(2, 3, 7);
        graph.addWeightedEdge(3, 4, 2);
        graph.addWeightedEdge(4, 0, 4);
        graph.addWeightedEdge(4, 1, 4);
        graph.addWeightedEdge(4, 5, 6);

        System.out.println("List Representation for Weighted graph:");
        graph.GraphRepresentation();
        System.out.println("\n");

        graph.addNode(2);
        System.out.println("After adding node, List Representation for Weighted graph:");
        graph.GraphRepresentation();
        System.out.println("\n");

        graph.removeNode(2);
        System.out.println("\n");

        graph.removeWeightedEdge(4, 5, 6);
        System.out.println("After removing weighted edge, List Representation for Weighted graph:");
        graph.GraphRepresentation();
        System.out.println("\n");


        CyclicGraph g1 = new CyclicGraph(4);

        // Add edges to create a cyclic graph
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 1);

        if (g1.isCyclic()) {
            System.out.println("The graph contains a cycle.");
            g1.GraphRepresentation();
            System.out.println("\n");

        } else {
            System.out.println("The graph does not contain a cycle.");
            System.out.println("\n");
        }


        AcyclicGraph g2 = new AcyclicGraph(6);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(0, 5);
        g2.addEdge(2, 4);


//        System.out.println("Original Graph:");
//        g2.printGraph();

        if (g2.isCyclic()) {
            System.out.println("The graph is acyclic.");
            g2.convertToCyclic();
            System.out.println("Converted to Cyclic Graph:");
            g2.GraphRepresentation();
        } else {
            System.out.println("The graph is already cyclic.");
        }

    }



}






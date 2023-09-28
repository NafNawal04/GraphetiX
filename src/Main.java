public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n");
        SimpleGraph s1 =new SimpleGraph(5);
        s1.addEdgeToNode(0,1);
        s1.addEdgeToNode(1,1); //should show error
        s1.addEdgeToNode(0,4);
        s1.addEdgeToNode(1,2);
        s1.addEdgeToNode(3,1);
        s1.addEdgeToNode(2,1); //should show error
        s1.addEdgeToNode(4,2);
        s1.addNewVertex(2); //two new nodes should be added to the list



        DirectedGraph d1 =new DirectedGraph(5);
        d1.addEdgeToNode(1,1);
        d1.addEdgeToNode(0,4);
        d1.addEdgeToNode(0,1);
        d1.addEdgeToNode(1,2);
        d1.addEdgeToNode(3,1);
        d1.addEdgeToNode(2,3);
        d1.addNewVertex(1);
        d1.addEdgeToNode(4,2);




        UndirectedGraph u1 = new UndirectedGraph(5);
        u1.addEdgeToNode(0,4);
        u1.addEdgeToNode(1,2);
        u1.addEdgeToNode(3,4);
        u1.addEdgeToNode(2,4);
        u1.addEdgeToNode(4,2);
        u1.addEdgeToNode(0,0);
        u1.addNewVertex(0);





        System.out.println("List Representation for Simple graph:");
        s1.representGraph(); // rearranges the values in ascending order and then visualizes the graph by showing the vertices one vertex is connected to in a linked list


        System.out.println("\n");
        System.out.println("List Representation for Directed graph:");
        d1.representGraph();
        d1.inDegree(1);
        d1.outDegree(1);


        System.out.println("\n");
        System.out.println("List Representation for Undirected graph:");
        u1.representGraph();
        u1.convertToDirected(1,2);


    }
}
import java.util.LinkedList;
public class WeightedGraph
{
    public  int node;
    public LinkedList<int[]>[] adjacencyList;

    public WeightedGraph(int node)
    {
        this.node = node;
        adjacencyList = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addWeightedEdge(int source, int destination, int weight)
    {
        int[] edge = {destination, weight};
        int[] edge2 ={source,weight};
        adjacencyList[source].addFirst(edge);
        adjacencyList[destination].addFirst(edge2);
    }

    public void GraphRepresentation() {
        for (int i = 0; i < node; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int[] edge : adjacencyList[i]) {
                System.out.print("(" + edge[0] + ", Weight: " + edge[1] + ") ");

            }
            System.out.println();
        }

    }



}

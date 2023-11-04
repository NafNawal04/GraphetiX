import libraryFunctions.Glist;


public class WeightedGraph
{
    public  int node;
    public Glist<int[]>[] adjacencyList;

    public WeightedGraph(int node)
    {
        this.node = node;
        adjacencyList = new Glist[node];
        for (int i = 0; i < node; i++) {
            adjacencyList[i] = new Glist<>();
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
            for (int j = 0; j < adjacencyList[i].length(); j++) {
                int[] edge = adjacencyList[i].get(j);
                System.out.print("(" + edge[0] + ", Weight: " + edge[1] + ") ");
            }
            System.out.println();
        }


    }



}

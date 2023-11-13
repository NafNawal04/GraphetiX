package libraryFunctions;

public class GraphTraversal {
    int start_node;
    int node;
    Glist<Integer> GraphRepresentationList[];
    public GraphTraversal(int i,Glist<Integer> GraphRepresentationList[],int n)
    {
        this.node=n;
        this.start_node=i;
        this.GraphRepresentationList= GraphRepresentationList;
    }
   public void bfs()
    {
        boolean[] visited = new boolean[node];

        Glist<Integer> queue = new Glist<>();

        visited[start_node] = true;
        queue.addQueue(start_node);

        while (!queue.isEmpty())
        {
            start_node = queue.pollQueue();
            System.out.print(start_node + " ");

            Glist<Integer> neighbors = GraphRepresentationList[start_node];
            neighbors.forEach(n -> {
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            });

        }
        System.out.print("\n");
    }
}

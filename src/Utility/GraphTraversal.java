package Utility;

public class GraphTraversal {
    int start_node;
    int node;
    CustomLInkedList<Integer> GraphRepresentationList[];
    public GraphTraversal( CustomLInkedList<Integer> GraphRepresentationList[], int n)
    {
        this.node=n;

        this.GraphRepresentationList= GraphRepresentationList;
    }
   public void bfs(int start_node)
    {
        boolean[] visited = new boolean[node];

        CustomLInkedList<Integer> queue = new CustomLInkedList<>();

        visited[start_node] = true;
        queue.addQueue(start_node);

        while (!queue.isEmpty())
        {
            start_node = queue.pollQueue();
            System.out.print(start_node + " ");

            CustomLInkedList<Integer> neighbors = GraphRepresentationList[start_node];
            neighbors.forEach(n -> {
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.addFIrst(n);
                }
            });

        }
        System.out.print("\n");
    }

    void DFSUtil(int start_node, boolean[] visited)
    {

        visited[start_node] = true;
        System.out.print(start_node + " ");


        GraphRepresentationList[start_node].forEach(n -> {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        });
    }

    public void DFS(int start_node)
    {
        boolean[] visited = new boolean[node];
        DFSUtil(start_node, visited);
    }

}

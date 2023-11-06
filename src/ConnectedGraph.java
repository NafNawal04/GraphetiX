
import libraryFunctions.Glist;

public class ConnectedGraph implements IGraph
{
    int node;
    int num_of_new_nodes;
    Glist<Integer> deletedIndex = new Glist<>();

    public Glist<Integer> GraphRepresentationList[];
    public ConnectedGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new Glist[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList[i] = new Glist<>();
        }
        for (int i = 0; i < node-1 ; i++)
        {
            GraphRepresentationList[i].add(i+1);
            GraphRepresentationList[i+1].add(i);
        }

    }

    @Override
    public void addEdge(int source, int dest)
    {
        if(deletedIndex.contains(source))
        {
            System.out.println("vertex "+ source+ " doesn't exist. So no edge can be added");
        }
        else
        {
            GraphRepresentationList[source].add(dest);
            GraphRepresentationList[dest].add(source);
            System.out.println("Added an edge between " + source + " & " + dest);
        }
    }
    @Override
    public void removeEdge(int source,int dest)
    {
        GraphRepresentationList[source].removeValue(dest);
        GraphRepresentationList[dest].removeValue(source);
        System.out.println("Removed the edge between " + source + " & " + dest);
    }

    @Override
    public void addNode(int node_num)
    {
            int dummy = node;
            num_of_new_nodes =  node + node_num;
            Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_nodes];

            for(int i = 0; i < node; i++)
            {
                newGraphRepresentList[i] = GraphRepresentationList[i];
            }

            for (int i = node; i < num_of_new_nodes; i++)
            {
                newGraphRepresentList[i] = new Glist<>();
            }

            node = num_of_new_nodes;
            GraphRepresentationList = newGraphRepresentList;

            for(int i= dummy-1;i<node-1;i++)
            {
                GraphRepresentationList[i].add(i+1);
                GraphRepresentationList[i+1].add(i);
            }


        System.out.println("Added "+ node_num+ " number of nodes in the Connected Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        deletedIndex.add(node_num);

        GraphRepresentationList[node_num].clear();

        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue(node_num);
        }
        GraphRepresentationList[node_num-1].add(node_num+1);
        GraphRepresentationList[node_num+1].add(node_num-1);
        System.out.println("Removed the node "+ node_num + " from the connected graph.");


    }
    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Connected graph:");
        for (int i = 0; i < GraphRepresentationList.length; i++)
        {

            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
        }

    }

    void bfs(int start_node)
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
    }
}

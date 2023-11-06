
import libraryFunctions.*;

public class SimpleGraph implements IGraph
{
    public int node;
    public int num_of_new_nodes;
    public Glist<Integer>[] GraphRepresentationList ;

    public SimpleGraph(int node)
    {

        this.node=node;
        GraphRepresentationList = new Glist[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentationList[i] = new Glist<>();
            i++;
        }
    }
    @Override
    public void addEdge(int source, int dest)
    {


        if(source == dest)
        {
            System.out.println("Cannot add any loop in simple graph.");
        }
        else
        {

            if(GraphRepresentationList[source].contains(dest)||GraphRepresentationList[dest].contains(source) )
            {
                System.out.println("Cannot add multi edges between two same nodes in simple graph");
            }

            else
            {
                GraphRepresentationList[source].add(dest);
                GraphRepresentationList[dest].add(source);
                System.out.println("Added an edge between " + source + " & " + dest);
            }
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
        num_of_new_nodes = node + node_num;
        Glist<Integer>[] newGraphRepresentationList = new Glist[num_of_new_nodes];
        for (int i = 0; i < node; i++)
        {
            newGraphRepresentationList[i] = GraphRepresentationList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentationList[i] = new Glist<>();
        }

        node = num_of_new_nodes;
        GraphRepresentationList = newGraphRepresentationList;

        System.out.println("Added "+ node_num+ " number of nodes in the Simple Graph.");
    }

    @Override
    public void removeNode(int node_num)
    {
        GraphRepresentationList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue(node_num);
        }
        System.out.println("Removed the node "+ node_num + " from the simple graph.");
        GraphRepresentation();

    }

    @Override
    public void GraphRepresentation()
    {

        System.out.println("List Representation for Simple graph:");
        for (int i = 0; i < GraphRepresentationList.length; i++)
        {
            if(!GraphRepresentationList[i].isEmpty())
            {
                System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
            }
            else
            {
                System.out.println("Vertex " + i + " is connected to: Empty List");
            }
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
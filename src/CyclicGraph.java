import libraryFunctions.*;


public class CyclicGraph implements IGraph
{
    public  int node;
    public int num_of_new_nodes;
    public Glist<Integer>[] GraphRepresentationList;

    public CyclicGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new Glist[node];
        for (int i = 0; i < node; i++) {
            GraphRepresentationList[i] = new Glist<>();
        }
    }

    @Override
    public void addEdge(int source, int dest)
    {
        GraphRepresentationList[source].add(dest);
        GraphRepresentationList[dest].add(source);
    }

    @Override
    public void removeEdge(int source,int dest)
    {
        GraphRepresentationList[source].removeValue(dest);
        GraphRepresentationList[dest].removeValue(source);
    }

    @Override
    public void addNode(int node_num)
    {
        num_of_new_nodes = node + node_num;
        Glist<Integer>[] newGraphRepresentList = new Glist[num_of_new_nodes];
        for (int i = 0; i < node; i++)
        {
            newGraphRepresentList[i] = GraphRepresentationList[i];
        }

        for (int i = node; i < num_of_new_nodes; i++)
        {
            newGraphRepresentList[i] = new Glist<>();
        }

        node = num_of_new_nodes;
        GraphRepresentationList = newGraphRepresentList;

    }


    @Override
    public void removeNode(int node_num)
    {
        GraphRepresentationList[node_num].clear();
        for (int i=0;i<node;i++)
        {
            GraphRepresentationList[i].removeValue(node_num);
        }
        System.out.println("After removing vertex "+ node_num + ", the cyclic graph becomes:");
        GraphRepresentation();

    }
    public boolean isCyclic()
    {
        boolean[] visited = new boolean[node];
        boolean[] stack = new boolean[node];

        for (int i = 0; i < node; i++)
        {
            if (!visited[i] && isCyclicUtil(i, visited, stack))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isCyclicUtil(int node, boolean[] visited, boolean[] stack) {
        visited[node] = true;
        stack[node] = true;

        for (int j = 0; j < GraphRepresentationList[node].length(); j++)
        {
            int neighbor = GraphRepresentationList[node].get(j);
            if (!visited[neighbor])
            {
                if (isCyclicUtil(neighbor, visited, stack))
                {
                    return true;
                }
            }
            else if (stack[neighbor])
            {
                return true;
            }
        }
        stack[node] = false;
        return false;
    }

    @Override
    public void GraphRepresentation()
    {
        for (int i = 0; i < node; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
        }
    }



}

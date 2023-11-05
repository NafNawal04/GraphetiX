
import java.util.*;

public class AcyclicGraph
{
    public  int node;
    public LinkedList<Integer>[] GraphRepresentationList ;

    public AcyclicGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new LinkedList[node];
        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest)
    {
        GraphRepresentationList[source].add(dest);
        GraphRepresentationList[dest].add(source);
    }



    public boolean isCyclic()
    {
        boolean[] visited = new boolean[node];
        boolean[] stack = new boolean[node];

        for (int i = 0; i < node; i++)
        {
            if (!visited[i] && isCyclicUtil(i, visited, stack))
            {
                return false;
            }
        }

        return true;
    }

    public boolean isCyclicUtil(int node, boolean[] visited, boolean[] stack)
    {
        visited[node] = true;
        stack[node] = true;

        for (int neighbor : GraphRepresentationList[node])
        {
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

    public void convertToCyclic()
    {
        if (!isCyclic())
        {
            System.out.println("The graph is already cyclic.");
            return;
        }

        for (int i = 0; i < node; i++)
        {
            for (int j = i + 1; j < node; j++)
            {
                if (!GraphRepresentationList[i].contains(j) && !GraphRepresentationList[j].contains(i))
                {
                    System.out.println("Adding edge between " + i + " and " + j + " to make the graph cyclic.");
                    addEdge(i, j);
                    return;
                }
            }
        }
    }

    public void GraphRepresentation()
    {
        for (int i = 0; i < node; i++)
        {
            System.out.println("Vertex " + i + " is connected to: " + GraphRepresentationList[i]);
        }
    }



}

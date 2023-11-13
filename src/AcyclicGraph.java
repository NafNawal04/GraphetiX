
import Utility.*;
import Graph.*;

public class AcyclicGraph implements IGraph
{
    public  int node;
    public int num_of_new_nodes;
    public CustomLInkedList<Integer>[] GraphRepresentationList ;

    public AcyclicGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLInkedList[node];
        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList[i] = new CustomLInkedList<>();
        }
    }

    @Override
    public void addEdge(int source, int dest)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.addEdge(source, dest);
    }



    @Override
    public void removeEdge(int source,int dest)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeEdge(source, dest);


    }


    @Override
    public void addNode(int node_num)
    {
        int num_of_new_nodes = node + node_num;
        GraphMethod g=new GraphMethod(GraphRepresentationList);


        GraphRepresentationList = g.addNode(node_num,node);
        node = num_of_new_nodes;
        System.out.println("Added "+ node_num+ " number of nodes in the Acyclic Graph.");
    }


    @Override
    public void removeNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the acyclic graph.");

    }
    public boolean isCyclic()
    {
        boolean[] visited = new boolean[node];
        boolean[] stack = new boolean[node];

        for (int i = 0; i < node; i++) {
            if (!visited[i] && isCyclicUtil(i, visited, stack)) {
                return false;
            }
        }

        return true;
    }

    public boolean isCyclicUtil(int node, boolean[] visited, boolean[] stack)
    {
        visited[node] = true;
        stack[node] = true;

        for (int j = 0; j < GraphRepresentationList[node].length(); j++) {
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

    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Acyclic graph:");
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.GraphRepresentation(node);
    }

    public void bfs(int start_node)
    {
        GraphTraversal graphTraversal=new GraphTraversal(GraphRepresentationList,node);
        graphTraversal.bfs(start_node);

    }
    public void dfs(int start_node)
    {
        GraphTraversal graphTraversal=new GraphTraversal(GraphRepresentationList,node);
        graphTraversal.DFS(start_node);

    }



}

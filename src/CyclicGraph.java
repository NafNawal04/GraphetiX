import Utility.*;
import Graph.*;

@SuppressWarnings({"unchecked","unused"})
public class CyclicGraph implements IGraph
{
    public  int node;

    public CustomLinkedList<int[]>[] GraphRepresentationList;

    public CyclicGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];
        for (int i = 0; i < node; i++) {
            GraphRepresentationList[i] = new CustomLinkedList<>();
        }
    }

    @Override
    public void addWeightedEdge(int source, int dest,int weight)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.addWeightedEdge(source, dest, weight);
    }



    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);


    }
    @Override
    public void addNode(int node_num)
    {

        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        System.out.println("Added "+ node_num+ " number of nodes in the Cyclic Graph.");
    }


    @Override
    public void removeNode(int node_num)
    {
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the Cyclic graph.");

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
            int[] neighbor = GraphRepresentationList[node].get(j);
            if (!visited[neighbor[0]])
            {
                if (isCyclicUtil(neighbor[0], visited, stack))
                {
                    return true;
                }
            }
            else if (stack[neighbor[0]])
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
        System.out.println("List Representation for Cyclic graph:");
        GraphMethod g=new GraphMethod(GraphRepresentationList);
        g.GraphRepresentation(node);
    }

    void bfs(int start_node)
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

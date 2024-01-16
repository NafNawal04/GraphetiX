package GraphTypes;

import CustomUtilityFunctions.*;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

@SuppressWarnings("unchecked")

public class AcyclicGraph implements IGraph
{
    public  int node;

    public CustomLinkedList<int[]>[] GraphRepresentationList ;

    public AcyclicGraph(int node)
    {
        this.node = node;
        GraphRepresentationList = new CustomLinkedList[node];
        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList[i] = new CustomLinkedList<>();
        }
    }

    @Override
    public void addWeightedEdge(int source, int dest,int weight)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addWeightedEdge(source, dest, weight);
    }



    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);


    }


    @Override
    public void addNode(int node_num)
    {

        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        System.out.println("Added "+ node_num+ " number of nodes in the Acyclic GraphDelegator.Graph.");
    }


    @Override
    public void removeNode(int node_num)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the Acyclic graph.");

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

                int length1 = GraphRepresentationList[i].length();
                int length2 = GraphRepresentationList[j].length();

                for(int x=0;x<length1;x++)
                {
                    int[] neededEdge1 = GraphRepresentationList[i].get(x);
                    for(int y=0;y<length2;y++)
                    {
                        int[] neededEdge2 = GraphRepresentationList[j].get(y);
                        if(neededEdge1[0] != j && neededEdge2[0] != i )
                        {
                            System.out.println("Adding edge between " + i + " and " + j + " to make the graph cyclic.");
                            addWeightedEdge(i, j,0);
                            return;
                        }
                    }
                }

            }
        }
    }

    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Acyclic graph:");
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphRepresentation(node);
    }

    public void bfs(int start_node)
    {
        TraversalMethod graphTraversal=new TraversalMethod(GraphRepresentationList,node);
        graphTraversal.BFS(start_node);

    }
    public void dfs(int start_node)
    {
        TraversalMethod graphTraversal=new TraversalMethod(GraphRepresentationList,node);
        graphTraversal.DFS(start_node);

    }



}

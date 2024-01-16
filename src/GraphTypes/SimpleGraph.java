package GraphTypes;

import CustomUtilityFunctions.*;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class SimpleGraph implements IGraph
{
    public int node;

    public CustomLinkedList<int[]>[] GraphRepresentationList;


    public SimpleGraph(int node)
    {

        this.node=node;
        GraphRepresentationList = new CustomLinkedList[node];

        int i=0;
        while(i<node)
        {
            GraphRepresentationList[i] = new CustomLinkedList<>();
            i++;
        }
    }
    @Override
    public void addWeightedEdge(int source, int dest,int weight)
    {
        BasicMethod g =new BasicMethod(GraphRepresentationList);

        if(source == dest)
        {
            System.out.println("Cannot add any loop in simple graph.");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the source & destination node: ");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            addWeightedEdge(s,d,0);
        }
        else
        {
            for(int x=0;x< GraphRepresentationList[source].length();x++)
            {
                int[] neededEdge1 = GraphRepresentationList[source].get(x);

                if (neededEdge1[0] == dest)
                {
                    System.out.println("Cannot add multi edges between two same nodes in simple graph");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the source & destination node: ");
                    int s = scanner.nextInt();
                    int d = scanner.nextInt();
                    addWeightedEdge(s,d,0);
                    return;
                }

            }
            for(int x=0;x< GraphRepresentationList[dest].length();x++)
            {
                int[] neededEdge2 = GraphRepresentationList[source].get(x);

                if (neededEdge2[0] == source)
                {
                    System.out.println("Cannot add multi edges between two same nodes in simple graph");
                    return;
                }
            }

            g.addWeightedEdge(source, dest, weight);
        }


    }
    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        BasicMethod g =new BasicMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);


    }

    @Override
    public void addNode(int node_num)
    {

        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addNode(node_num,node);
        System.out.println("Added "+ node_num+ " number of nodes in the Simple GraphDelegator.Graph.");
    }

    @Override
    public void removeNode(int node_num)
    {
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the simple graph.");


    }

    @Override
    public void GraphRepresentation()
    {

        System.out.println("List Representation for Simple graph:");
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
package GraphTypes;

import CustomUtilityFunctions.*;
import GraphFunctionalities.*;
import GraphInterface.IGraph;

@SuppressWarnings("unchecked")

public class DisconnectedGraph implements IGraph
{
    int node;

    CustomLinkedList<Integer> deletedIndex = new CustomLinkedList<>();
    public CustomLinkedList<int[]>[] GraphRepresentationList;
    public DisconnectedGraph(int node)
    {
        this.node= node;
        GraphRepresentationList = new CustomLinkedList[node];

        for (int i = 0; i < node; i++)
        {
            GraphRepresentationList [i] = new CustomLinkedList<>();
        }
    }


    @Override
    public void addNode(int node_num)
    {

        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.addNode(node_num,node);

        System.out.println("Added "+ node_num+ " number of nodes in the Disconnected GraphDelegator.Graph.");
    }
    @Override
    public void removeNode(int node_num)
    {
        deletedIndex.addLast(node_num);
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.removeNode(node_num,node);
        System.out.println("Removed the node "+ node_num + " from the disconnected graph.");

    }
    @Override
    public void addWeightedEdge(int source, int dest,int weight)
    {
        if(deletedIndex.contains(source))
        {
            System.out.println("vertex "+ source+ " doesn't exist. So no edge can be added");
        }
        else {
            BasicMethod g =new BasicMethod(GraphRepresentationList);
            g.addWeightedEdge(source,dest,weight);
        }
    }
    @Override
    public void removeWeightedEdge(int source,int dest,int weight)
    {
        BasicMethod g =new BasicMethod(GraphRepresentationList);
        g.removeWeightedEdge(source, dest,weight);


    }

    @Override
    public void GraphRepresentation()
    {
        System.out.println("List Representation for Disconnected graph:");
        BasicMethod g=new BasicMethod(GraphRepresentationList);
        g.GraphRepresentation(node);

    }


    public void bfs(int start_node)
    {
        TraversalMethod graphTraversal=new TraversalMethod(GraphRepresentationList,node);
        graphTraversal.bfs(start_node);

    }
    public void dfs(int start_node)
    {
        TraversalMethod graphTraversal=new TraversalMethod(GraphRepresentationList,node);
        graphTraversal.DFS(start_node);

    }
}


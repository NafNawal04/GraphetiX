public interface IGraph
{
    void addEdge(int source,int dest);
    void addNode(int node_num);
    void removeNode(int node_num);
    void removeEdge(int source,int dest);
    void GraphRepresentation();
}

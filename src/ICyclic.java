public interface ICyclic {
    public boolean isCyclic();
    public boolean isCyclicUtil(int node, boolean[] visited, boolean[] stack);
}

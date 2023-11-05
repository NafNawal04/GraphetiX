
public class Graph
{
    public SimpleGraph s1;
    public DirectedGraph d1;
    public UndirectedGraph u1;
    public ConnectedGraph c1;
    public DisconnectedGraph dc1;
    public CompleteGraph cp1;
    public WeightedGraph w1;
    public AcyclicGraph a1;
    public CyclicGraph cc1;
    public Graph(String type,Integer node)
    {
      if(type.equalsIgnoreCase("SimpleGraph"))
      {
          s1 = new SimpleGraph(node);

      }
      else if(type.equalsIgnoreCase("DirectedGraph"))
      {
          d1 = new DirectedGraph(node);

      }
      else if(type.equalsIgnoreCase("UndirectedGraph"))
      {
           u1 = new UndirectedGraph(node);

      }
      else if(type.equalsIgnoreCase("ConnectedGraph"))
      {
           c1 = new ConnectedGraph(node);

      }
      else if(type.equalsIgnoreCase("DisconnectedGraph"))
      {
           dc1 = new DisconnectedGraph(node);

      }
      else if(type.equalsIgnoreCase("CompleteGraph"))
      {
           cp1 = new CompleteGraph(node);

      }
      else if(type.equalsIgnoreCase("WeightedGraph"))
      {
           w1 = new WeightedGraph(node);

      }
      else if(type.equalsIgnoreCase("AcyclicGraph"))
      {
           a1 = new AcyclicGraph(node);

      }
      else if(type.equalsIgnoreCase("CyclicGraph"))
      {
           cc1 = new CyclicGraph(node);

      }
      else
      {
          System.out.println("Not a valid request.");
      }

    }


    public SimpleGraph getSimple()
    {
        return s1;
    }

    public DirectedGraph getDirected()
    {
        return d1;
    }

    public UndirectedGraph getUndirected()
    {
        return u1;
    }

    public ConnectedGraph getConnectedG()
    {
        return c1;
    }

    public DisconnectedGraph getDisconnected()
    {
        return dc1;
    }
    public CompleteGraph getComplete()
    {
        return cp1;
    }

    public WeightedGraph getWeighted()
    {
        return w1;
    }

    public AcyclicGraph getAcyclic()
    {
        return a1;
    }

    public CyclicGraph getCyclic()
    {
        return cc1;
    }

}

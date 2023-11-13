import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Graphetix");
        int choice;
        do {
            System.out.println("MAIN MENU");
            System.out.println("1. Create a graph");
            System.out.println("2. Exit");
            System.out.print("Press the number for the desired operation: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    createGraph(scanner);
                    break;
                case 2:
                    System.out.println("Thank you for using Graphetix");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }

    public static void createGraph(Scanner scanner)
    {
        System.out.println("Which type of graph do you want to create?");
        System.out.println("1. Simple Graph");
        System.out.println("2. Directed Graph");
        System.out.println("3. Undirected Graph");
        System.out.println("4. Connected Graph");
        System.out.println("5. Disconnected Graph");
        System.out.println("6. Complete Graph");
        System.out.println("7. Weighted Graph");
        System.out.println("8. Acyclic Graph");
        System.out.println("9. Cyclic Graph");
        System.out.print("Press the number for the desired graph type: ");
        int graphType = scanner.nextInt();

        Graph s1;
        Integer node;

        switch (graphType)
        {
            case 1:
                System.out.print("How many nodes do you want to start your Simple Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Simple Graph",node);
                OperationSimple(scanner,s1);
                break;
            case 2:
                System.out.print("How many nodes do you want to start your Directed Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Directed Graph",node);
                OperationDirected(scanner,s1);
                break;
            case 3:
                System.out.print("How many nodes do you want to start your Undirected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Undirected Graph",node);
                OperationUndirected(scanner,s1);
                break;
            case 4:
                System.out.print("How many nodes do you want to start your Connected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Connected Graph",node);
                OperationConnected(scanner,s1);
                break;
            case 5:
                System.out.print("How many nodes do you want to start your Disconnected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Disconnected Graph",node);
                OperationDisconnected(scanner,s1);

                break;
            case 6:
                System.out.print("How many nodes do you want to start your Complete Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Complete Graph",node);
                OperationComplete(scanner,s1);

                break;
            case 7:
                System.out.print("How many nodes do you want to start your Weighted Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Weighted Graph",node);
                OperationWeighted(scanner,s1);

                break;
            case 8:
                System.out.print("How many nodes do you want to start your Acyclic Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Acyclic Graph",node);
                OperationAcyclic(scanner,s1);

                break;
            case 9:
                System.out.print("How many nodes do you want to start your Cyclic Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Cyclic Graph",node);
                OperationCyclic(scanner,s1);

                break;
            default:
                System.out.println("Invalid graph type choice. Please try again.");

        }

    }

    public static void OperationSimple(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Find the Breadth-First Traversal of a node");
            System.out.println("6. Find the Depth-First Traversal of a node");
            System.out.println("7. Show the Graph in Adjacency List");
            System.out.println("6. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getSimple().addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getSimple().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getSimple().removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getSimple().removeNode(node_num);
                    break;
                case 5:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getSimple().bfs(start_node);
                    break;
                case 7:
                    s1.getSimple().GraphRepresentation();
                    break;
                case 6:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getSimple().dfs(start_node);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationDirected(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Find the Breadth-First Traversal of a node");
            System.out.println("6. Find the depth-First Traversal of a node");
            System.out.println("7. Show the Graph in Adjacency List");
            System.out.println("8. Find the in degree of a node");
            System.out.println("9. Find the out degree of a node");
            System.out.println("10. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getDirected().addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getDirected().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getDirected().removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getDirected().removeNode(node_num);
                    break;
                case 5:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getDirected().bfs(start_node);
                    break;
                case 6:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getDirected().dfs(start_node);
                    break;
                case 7:
                    s1.getDirected().GraphRepresentation();
                    break;
                case 8:
                    System.out.print("Enter the node for finding in degree: ");
                    dest = scanner.nextInt();
                    s1.getDirected().inDegree(dest);
                    break;
                case 9:
                    System.out.print("Enter the node for finding out degree: ");
                    source = scanner.nextInt();
                    s1.getDirected().outDegree(source);
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationUndirected(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Find the Breadth-First Traversal of a node");
            System.out.println("6. Find the Depth-First Traversal of a node");
            System.out.println("7. Show the Graph in Adjacency List");
            System.out.println("8. Convert an edge from undirected to directed");
            System.out.println("9. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getUndirected().addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getUndirected().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getUndirected().removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getUndirected().removeNode(node_num);
                    break;
                case 5:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getUndirected().bfs(start_node);
                    break;
                case 6:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getUndirected().dfs(start_node);
                    break;
                case 7:
                    s1.getUndirected().GraphRepresentation();
                    break;
                case 8:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getUndirected().convertToDirected(source,dest);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationConnected(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Find the Breadth-First Traversal of a node");
            System.out.println("6. Find the Depth-First Traversal of a node");
            System.out.println("7. Show the Graph in Adjacency List");
            System.out.println("8. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getConnectedG().addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getConnectedG().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getConnectedG().removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getConnectedG().removeNode(node_num);
                    break;
                case 5:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getConnectedG().bfs(start_node);
                    break;
                case 6:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getConnectedG().dfs(start_node);
                    break;
                case 7:
                    s1.getConnectedG().GraphRepresentation();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationDisconnected(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Find the Breadth-First Traversal of a node");
            System.out.println("6. Find the Depth-First Traversal of a node");
            System.out.println("7. Show the Graph in Adjacency List");
            System.out.println("8. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getDisconnected().addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getDisconnected().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getDisconnected().removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getDisconnected().removeNode(node_num);
                    break;
                case 5:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getDisconnected().bfs(start_node);
                    break;
                case 6:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getDisconnected().dfs(start_node);
                    break;
                case 7:
                    s1.getDisconnected().GraphRepresentation();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }




    public static void OperationComplete(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add any number of nodes to the graph");
            System.out.println("2. Remove a specific node from the graph");
            System.out.println("3. Find the Breadth-First Traversal of a node");
            System.out.println("4. Find the depth-First Traversal of a node");
            System.out.println("5. Show the Graph in Adjacency List");
            System.out.println("6. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getComplete().addNode(node_num);
                    break;
                case 2:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getComplete().removeNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getComplete().bfs(start_node);
                    break;
                case 6:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getComplete().dfs(start_node);
                    break;
                case 4:
                    s1.getComplete().GraphRepresentation();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }


    public static void OperationWeighted(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add a weighted edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove a specific node from the graph");
            System.out.println("4. Remove a weighted edge between two nodes");
            System.out.println("5. Show the Graph in Adjacency List");
            System.out.println("6. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int node_num;
            int weight;

            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    System.out.print("Enter the weight: ");
                    weight = scanner.nextInt();
                    s1.getWeighted().addWeightedEdge(source,dest,weight);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getWeighted().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getWeighted().removeNode(node_num);
                    break;
                case 4:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    System.out.print("Enter the weight: ");
                    weight = scanner.nextInt();
                    s1.getWeighted().removeWeightedEdge(source,dest,weight);
                    break;
                case 5:
                    s1.getWeighted().GraphRepresentation();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }



    public static void OperationAcyclic(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Convert the Acyclic graph into Cyclic");
            System.out.println("6. Show the Graph in Adjacency List");
            System.out.println("7. Find the Breadth-First Traversal of a node");
            System.out.println("8. Find the depth-First Traversal of a node");
            System.out.println("9. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getAcyclic().addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getAcyclic().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getAcyclic().removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getAcyclic().removeNode(node_num);
                    break;
                case 5:
                    s1.getAcyclic().convertToCyclic();
                    break;
                case 6:
                    s1.getAcyclic().GraphRepresentation();
                    break;
                case 7:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getAcyclic().bfs(start_node);
                    break;
                case 8:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getAcyclic().dfs(start_node);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }


    public static void OperationCyclic(Scanner scanner,Graph s1)
    {

        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Show the Graph in Adjacency List");
            System.out.println("6. Find the Breadth-First Traversal of a node");
            System.out.println("7. Find the depth-First Traversal of a node");
            System.out.println("8. Exit");
            System.out.print("Press the number for the desired operation: ");
            int task = scanner.nextInt();

            int source;
            int dest;
            int start_node;
            int node_num;
            switch (task)
            {
                case 1:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getCyclic().addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    s1.getCyclic().addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    s1.getCyclic().removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    s1.getCyclic().removeNode(node_num);
                    break;
                case 5:
                    s1.getCyclic().GraphRepresentation();
                    break;
                case 6:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    s1.getCyclic().bfs(start_node);
                    break;
                case 7:
                    System.out.print("Enter the start node of the Depth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Depth First Traversal for the "+start_node+" is: ");
                    s1.getCyclic().dfs(start_node);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }

}






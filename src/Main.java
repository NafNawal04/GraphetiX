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

                break;
            case 3:
                System.out.print("How many nodes do you want to start your Undirected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Undirected Graph",node);

                break;
            case 4:
                System.out.print("How many nodes do you want to start your Connected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Connected Graph",node);

                break;
            case 5:
                System.out.print("How many nodes do you want to start your Disconnected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Disconnected Graph",node);

                break;
            case 6:
                System.out.print("How many nodes do you want to start your Complete Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Complete Graph",node);

                break;
            case 7:
                System.out.print("How many nodes do you want to start your Weighted Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Weighted Graph",node);

                break;
            case 8:
                System.out.print("How many nodes do you want to start your Acyclic Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Acyclic Graph",node);

                break;
            case 9:
                System.out.print("How many nodes do you want to start your Cyclic Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Cyclic Graph",node);
                break;
            default:
                System.out.println("Invalid graph type choice. Please try again.");

        }

    }

    public static void OperationSimple(Scanner scanner,Graph s1)
    {
        SimpleGraph q1 = s1.getSimple();
        while (true)
        {
            System.out.println("Which operation do you want to perform?");
            System.out.println("1. Add edge between two nodes");
            System.out.println("2. Add any number of nodes to the graph");
            System.out.println("3. Remove edge between two nodes");
            System.out.println("4. Remove a specific node from the graph");
            System.out.println("5. Find the Breadth-First Traversal of a node");
            System.out.println("6. Show the Graph in Adjacency List");
            System.out.println("7. Exit");
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
                    q1.addEdge(source,dest);
                    break;
                case 2:
                    System.out.print("Enter the number of nodes to be added: ");
                    node_num = scanner.nextInt();
                    q1.addNode(node_num);
                    break;
                case 3:
                    System.out.print("Enter the source node: ");
                    source = scanner.nextInt();
                    System.out.print("Enter the destination node: ");
                    dest = scanner.nextInt();
                    q1.removeEdge(source,dest);
                    break;
                case 4:
                    System.out.print("Enter the node number to be removed: ");
                    node_num = scanner.nextInt();
                    q1.removeNode(node_num);
                    break;
                case 5:
                    System.out.print("Enter the start node of the Breadth First Traversal: ");
                    start_node = scanner.nextInt();
                    System.out.println("The Breadth First Traversal for the "+start_node+" is: ");
                    q1.bfs(start_node);
                    break;
                case 6:
                    q1.GraphRepresentation();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }

}






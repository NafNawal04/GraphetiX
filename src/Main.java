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
        int node;

        switch (graphType)
        {
            case 1:
                System.out.print("How many nodes do you want to start your Simple Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Simple Graph",node);
                Operations(scanner,s1);
                break;
            case 2:
                System.out.print("How many nodes do you want to start your Directed Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Directed Graph",node);
                Operations(scanner,s1);
                break;
            case 3:
                System.out.print("How many nodes do you want to start your Undirected Graph with? ");
                node = scanner.nextInt();
                s1 = new Graph("Undirected Graph",node);
                Operations(scanner,s1);
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            default:
                System.out.println("Invalid graph type choice. Please try again.");

        }

    }

    public static void Operations(Scanner scanner,Graph s1)
    {
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
            int operation = scanner.nextInt();

            switch (operation)
            {
                case 1:
                    int source = scanner.nextInt();
                    int dest = scanner.nextInt();
                    s1.getSimple().addEdge(source,dest);
                    break;
                case 2:
                    // Implement logic to add nodes to the graph
                    break;
                case 3:
                    // Implement logic to remove an edge between two nodes
                    break;
                case 4:
                    // Implement logic to remove a specific node from the graph
                    break;
                case 5:
                    // Implement logic to find the Breadth-First Traversal of a node
                    break;
                case 6:
                    // Implement logic to show the Graph in Adjacency List
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }

}






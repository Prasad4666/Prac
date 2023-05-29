import java.util.Scanner;

public class Mainmethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1.Depth First Search \n2. Breadth First Search \n3. Exit");
            System.out.println("Enter Your Choice :");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.println("Enter the Total Number of Nodes : ");
                int total1 = sc.nextInt();
                DepthFirstSearch a = new DepthFirstSearch(total1);

                for (int i = 0; i < total1; i++) {
                    System.out.println("Enter the Source Node : ");
                    int s = sc.nextInt();
                    System.out.println("Enter the Destination Node : ");
                    int d = sc.nextInt();
                    a.addEdge(s, d);

                }

                System.out.println("Enter the Node from where u want to Start Traversal :");
                int initial1 = sc.nextInt();
                a.DFS(initial1);
            }

            if (ch == 2) {
                System.out.println("Enter the Total Number of Nodes : ");
                int total2 = sc.nextInt();
                BreadthFirstSearch x = new BreadthFirstSearch(total2);

                for (int i = 0; i < total2; i++) {
                    System.out.println("Enter the Source Node : ");
                    int ss = sc.nextInt();
                    System.out.println("Enter the Destination Node : ");
                    int dd = sc.nextInt();
                    x.addEdge(ss, dd);
                }

                System.out.println("Enter the Node from where u want to Start Traversal :");
                int initial2 = sc.nextInt();
                x.BFS(initial2);
            }

            if (ch == 3) {
                System.exit(0);
            }

            System.out.println("\nContinue Press 1 :");
        } while (sc.nextInt() == 1);
    }
}

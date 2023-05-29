// import java.util.*;

// public class BreadthFirstSearch {

//     public LinkedList<Integer> adj[];
//     public boolean visited[];

//     public BreadthFirstSearch(int vertices) {
//         adj = new LinkedList[vertices];
//         visited = new boolean[vertices];

//         for (int i = 0; i < adj.length; i++) {

//             adj[i] = new LinkedList<Integer>();

//         }
//     }

//     public void addEdge(int src, int dest) {
//         adj[src].add(dest);
//     }

//     public void BFS(int vertex) {

//         LinkedList<Integer> queue = new LinkedList<Integer>();

//         visited[vertex] = true;
//         queue.add(vertex);

//         while (queue.size() != 0) {
//             vertex = queue.poll();
//             System.out.print(vertex + " ");

//             Iterator<Integer> itr = adj[vertex].listIterator();
//             while (itr.hasNext()) {
//                 int adv = itr.next();
//                 if (!visited[adv]) {
//                     visited[adv] = true;
//                     queue.add(adv);
//                 }
//             }
//         }

//     }
// }

import java.util.*;

public class BreadthFirstSearch {

    LinkedList<Integer> adj[];
    boolean visited[];

    public BreadthFirstSearch(int vertices) {
        adj = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {

            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    public void BFS(int vertex) {

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            vertex = queue.poll();
            System.out.print(vertex + " ");

            Iterator<Integer> itr = adj[vertex].listIterator();
            while (itr.hasNext()) {
                int adv = itr.next();
                if (!visited[adv]) {
                    visited[adv] = true;
                    queue.add(adv);
                }
            }
        }
    }
}
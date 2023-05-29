// import java.util.*;

// public class DepthFirstSearch {

//     public LinkedList<Integer> adjlist[];
//     public boolean visited[];

//     public DepthFirstSearch(int vertices) {

//         adjlist = new LinkedList[vertices];
//         visited = new boolean[vertices];

//         for (int i = 0; i < adjlist.length; i++) {

//             adjlist[i] = new LinkedList<Integer>();

//         }
//     }

//     public void addEdge(int src, int dest) {

//         adjlist[src].add(dest);

//     }

//     public void DFS(int vertex) {

//         visited[vertex] = true;
//         System.out.print(vertex + " ");

//         Iterator<Integer> itr = adjlist[vertex].listIterator();
//         while (itr.hasNext()) {
//             int adj = itr.next();
//             if (!visited[adj]) {
//                 DFS(adj);
//             }
//         }
//     }
// }

import java.util.*;

public class DepthFirstSearch {
    LinkedList<Integer> adjlist[];
    boolean visited[];

    public DepthFirstSearch(int vertices) {
        adjlist = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjlist[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int src, int dest) {
        adjlist[src].add(dest);
    }

    public void DFS(int vertex) {

        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> itr = adjlist[vertex].listIterator();
        while (itr.hasNext()) {
            int adj = itr.next();
            if (!visited[adj]) {
                DFS(adj);
            }
        }

    }
}
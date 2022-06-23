package com.datastructures.graphs;

import java.util.Arrays;
import java.util.List;

public class GraphDFSRecursive {

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<GraphDFS.Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected
                new GraphDFS.Edge(1, 2), new GraphDFS.Edge(1, 7), new GraphDFS.Edge(1, 8),
                new GraphDFS.Edge(2, 3), new GraphDFS.Edge(2, 6), new GraphDFS.Edge(3, 4),
                new GraphDFS.Edge(3, 5), new GraphDFS.Edge(8, 9), new GraphDFS.Edge(8, 12),
                new GraphDFS.Edge(9, 10), new GraphDFS.Edge(9, 11)
                // , new Edge(6, 9)        // introduce a cycle
        );

        // total number of nodes in the graph (0–12)
        final int N = 13;

        // build a graph from the given edges
        GraphDFS.Graph graph = new GraphDFS.Graph(edges, N);

        // to keep track of whether a vertex is discovered or not
        System.out.println("DFS RECURSIVE: ");
        boolean [] discovered = new boolean[N];
        // Perform DFS traversal from all undiscovered nodes to
        // cover all unconnected components of a graph
        for (int i = 0; i < N; i++)
        {
            if (!discovered[i]) {
                DFS(graph, i, discovered);
            }
        }
    }
    // DFS Recursive
    public static void DFS(GraphDFS.Graph graph, int v, boolean[] discovered)
    {
        // mark the current node as discovered
        discovered[v] = true;

        // print the current node
        System.out.print(v + " ");

        // do for every edge `v —> u`
        for (int u: graph.adjList.get(v))
        {
            // if `u` is not yet discovered
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }
}

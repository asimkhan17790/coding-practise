package com.datastructures.graphs;

import java.util.*;

public class GraphBFSRecursive {

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<GraphBFSRecursive.Edge> edges = Arrays.asList(
                new GraphBFSRecursive.Edge(1, 2), new GraphBFSRecursive.Edge(1, 3), new GraphBFSRecursive.Edge(1, 4),
                new GraphBFSRecursive.Edge(2, 5), new GraphBFSRecursive.Edge(2, 6), new GraphBFSRecursive.Edge(5, 9),
                new GraphBFSRecursive.Edge(5, 10), new GraphBFSRecursive.Edge(4, 7), new GraphBFSRecursive.Edge(4, 8),
                new GraphBFSRecursive.Edge(7, 11), new GraphBFSRecursive.Edge(7, 12)
                // vertex 0, 13, and 14 are single nodes
        );

        // total number of nodes in the graph
        final int N = 15;
        // build a graph from the given edges
        GraphBFSRecursive.Graph graph = new GraphBFSRecursive.Graph(edges, N);


        // Recursive BFS
        // create a queue for doing BFS
        Queue<Integer> q = new ArrayDeque<>();
        // to keep track of whether a vertex is discovered or not

        boolean[] discovered = new boolean[N];
        // Perform BFS traversal from all undiscovered nodes to
        // cover all unconnected components of a graph
        System.out.println();
        System.out.println("BFS Recursive: ");
        for (int i = 0; i < N; i++)
        {
            if (discovered[i] == false)
            {
                // mark the source vertex as discovered
                discovered[i] = true;
                // enqueue source vertex
                q.add(i);
                // start BFS traversal from vertex `i`
                recursiveBFS(graph, q, discovered);
            }
        }
    }

    // Perform BFS recursively on the graph
    //Recursive
    public static void recursiveBFS(GraphBFSRecursive.Graph graph, Queue<Integer> q,
                                    boolean[] discovered)
    {
        if (q.isEmpty()) {
            return;
        }

        // dequeue front node and print it
        int v = q.poll();
        System.out.print(v + " ");

        // do for every edge `v —> u`
        for (int u: graph.adjList.get(v))
        {
            if (!discovered[u])
            {
                // mark it as discovered and enqueue it
                discovered[u] = true;
                q.add(u);
            }
        }

        recursiveBFS(graph, q, discovered);
    }

    static class Edge
    {
        int source, dest;
        public Edge(int source, int dest)
        {
            this.source = source;
            this.dest = dest;
        }
    }

    // A class to represent a graph object
    static class Graph
    {
        // A list of lists to represent an adjacency list
        List<List<Integer>> adjList = null;

        // Constructor
        Graph(List<GraphBFSRecursive.Edge> edges, int N)
        {
            adjList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }

            // add edges to the undirected graph
            for (GraphBFSRecursive.Edge edge: edges)
            {
                int src = edge.source;
                int dest = edge.dest;

                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }
    }
}

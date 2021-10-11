package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


// taken from https://www.techiedelight.com/depth-first-search/
public class GraphDFS {    

    // A class to store a graph edge
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
     
        List<List<Integer>> adjList = null;
    
        // Constructor
        Graph(List<Edge> edges, int N)
        {
            adjList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }
    
            // add edges to the undirected graph
            for (Edge edge: edges)
            {
                int src = edge.source;
                int dest = edge.dest;
    
                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }
    }


    // DFS Recursive
    public static void DFS(Graph graph, int v, boolean[] discovered)
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


    ////////////////////////////// ITERATIVE /////////////////////////////////
    // Perform iterative DFS on graph `g` starting from vertex `v`
    public static void iterativeDFS(Graph graph, int v, boolean[] discovered){
    // create a stack used to do iterative DFS
    Stack<Integer> stack = new Stack<>();

    // push the source node into the stack
    stack.push(v);

    // loop till stack is empty
    while (!stack.empty())
    {
        // Pop a vertex from the stack
        v = stack.pop();

        // if the vertex is already discovered yet, ignore it

        // WHY DO THIS?
        if (discovered[v]) {
            continue;
        }

        // we will reach here if the popped vertex `v`
        // is not discovered yet; print it and process
        // its undiscovered adjacent nodes into the stack
        discovered[v] = true;
        System.out.print(v + " ");

        // do for every edge `v —> u`
        List<Integer> adj = graph.adjList.get(v);
        for (int i = adj.size() - 1; i >= 0; i--)
        {
            int u = adj.get(i);
            if (!discovered[u]) {
                stack.push(u);
            }
        }
    }
}
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
                new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
                new Edge(9, 10), new Edge(9, 11)
                // , new Edge(6, 9)        // introduce a cycle
        );
 
        // total number of nodes in the graph (0–12)
        final int N = 13;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, N);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // Do iterative DFS traversal from all undiscovered nodes to
        // cover all unconnected components of a graph

        System.out.println("DFS Iterative: ");
        for (int i = 0; i < N; i++)
        {
            if (!discovered[i]) {
                iterativeDFS(graph, i, discovered);
            }
        }

        System.out.println();
        System.out.println("DFS RECURSIVE: ");
        discovered = new boolean[N];
         // Perform DFS traversal from all undiscovered nodes to
        // cover all unconnected components of a graph
        for (int i = 0; i < N; i++)
        {
            if (!discovered[i]) {
                DFS(graph, i, discovered);
            }
        }
    }
}

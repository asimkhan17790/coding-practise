package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological "
                           + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }    
    static class Graph {
        int V;
        List<ArrayList<Integer>> adj;
        Graph(int v)
        {
            V = v;
            adj = new ArrayList<ArrayList<Integer> >(v);
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<Integer>());
        }
        void addEdge(int v, int w) { 
            adj.get(v).add(w); 
        }
        void DFS(Integer v, boolean visited[], Stack<Integer> stack){
            visited[v] = true;
            for (Integer child: adj.get(v)){
                if (!visited[child]){
                    DFS(child,visited,stack);
                }
            }
            stack.push(v);
        }
        void topologicalSort() {
            boolean[] visited = new boolean[V];
            Arrays.fill(visited,false);
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < V; i++){
                if (visited[i]== false){
                    DFS(i, visited, stack);
                }
            }
            // Print contents of stack
            while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
        }
    }
}

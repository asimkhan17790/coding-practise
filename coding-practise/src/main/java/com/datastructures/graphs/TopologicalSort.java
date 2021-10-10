package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        //g.addEdge(3, 5);
 
        System.out.print("Printing Topological Sort: ");
                           
        // Function Call
        g.topologicalSort();
        System.out.println("");
        if (g.doesCycleExistUsingTopologicalSort()){
            System.out.println("Cycle Exists");
        }else {
            System.out.println("Cycle Doesn't Exists");
        }
    }    
    static class Graph {
        int V;
        List<ArrayList<Integer>> adj;
        Stack<Integer> stack;
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
                if (visited[child] ==  false){
                    DFS(child,visited,stack);
                }
            }
            stack.push(v);
        }
        
        void topologicalSort() {
            boolean[] visited = new boolean[V];
            Arrays.fill(visited,false);
            stack = new Stack<Integer>();
            for (int i = 0; i < V; i++){
                if (visited[i] == false){
                    DFS(i, visited, stack);
                }
            }
            // Print contents of stack
            Stack<Integer> s = (Stack<Integer>)stack.clone();
            while (s.empty() == false){
                System.out.print(s.pop() + " ");
            }
                
        }

        boolean doesCycleExistUsingTopologicalSort() {
                Map<Integer,Integer> vertexPositionMap = new HashMap<>();
                int i = 0;
                while (!stack.isEmpty()) {
                    Integer item = stack.pop();
                    vertexPositionMap.put(i++,item);                     
                }

                for (int j = 0; j < V; j++){
                    for (Integer child: adj.get(j)){
                        if (vertexPositionMap.get(j) > vertexPositionMap.get(child)){
                            return true;
                        }
                    }
                }

                return false;
        
        }
    }
}

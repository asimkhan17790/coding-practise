package com.datastructures.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


// Find Cycle in a directed Graph
public class FindCycleInAGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        //graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        //graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle");
    }

    
 static class Graph {
     private final int V;
     private final Map<Integer,List<Integer>> adjList;
     enum Color {WHITE, GRAY, BLACK};
     Graph(int V){
        this.V = V;
        adjList = new HashMap<>();

        for (int i = 0;i<V;i++){
            adjList.put(i,new LinkedList<>());
        }
     }

    private void addEdge(int source, int dest) {
        adjList.get(source).add(dest);
    }

    boolean isCyclic(){

        Color[] color = new Color[V];
        
        Arrays.fill(color,Color.WHITE);            

        for (int i = 0; i<V; i++){
            if (color[i] == Color.WHITE){
                if (isCyclicUtil(i,color)) return true;
            }           
        }
        return false;
    }
    
    boolean isCyclicUtil(int node,Color[] color){
        color[node] = Color.GRAY;
        for (Integer c: this.adjList.get(node)){
            if (color[c] == Color.GRAY){
                return true;                
            }
            if (color[c]== Color.WHITE && isCyclicUtil(c, color)){
                return true;
            }
        }
        color[node] = Color.BLACK;
        return false;
       
    }
 }   
}

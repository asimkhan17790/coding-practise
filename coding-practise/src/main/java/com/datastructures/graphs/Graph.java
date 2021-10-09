package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

// Copied from Baeldung
public class Graph {
    
    public Map<Vertex, List<Vertex>> adjList;

    public Graph(){
        adjList = new HashMap<>();
    }

    public void addVertex(String label) {
        adjList.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjList.values().stream().forEach(e -> e.remove(v));
        adjList.remove(new Vertex(label));
    }

    // as we are considering an undirected graph
    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjList.get(v1);
        List<Vertex> eV2 = adjList.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex> getAdjVertices(String label) {
        return adjList.get(new Vertex(label));
    }

    // Depth First Traversal
    public Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visitedVertices = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            String vertex = stack.pop();
            if (!visitedVertices.contains(vertex)) {
                visitedVertices.add(vertex);
                for (Vertex v: graph.getAdjVertices(vertex)){
                    stack.push(v.label);
                    }
            }            
        }
        return visitedVertices;
    }

    // Breadth First Traversal
    public Set<Vertex> breadthFirstTraversal(Graph graph, String root){
        Vertex source = new Vertex(root);
        source.distance = 0;

        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(source);
        visited.add(source);        
        while(!queue.isEmpty()){

            Vertex vertex = queue.poll();
            //visited.add(vertex);// when you poll, you add to the visited list --> DO THIS OR DO LINE NUMBER 77 (above commented line)
            //System.out.println(vertex);
            for (Vertex v: graph.getAdjVertices(vertex.label)){
                if (!visited.contains(v)) {
                    visited.add(v);
                    v.distance = vertex.distance+1;
                    v.parent = vertex;
                    queue.add(v);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");    

        // Call DFS
        System.out.println("DFS: " + graph.depthFirstTraversal(graph, "Bob"));

        // Call DFS
        System.out.println("BFS" + graph.breadthFirstTraversal(graph, "Bob"));
    }




}

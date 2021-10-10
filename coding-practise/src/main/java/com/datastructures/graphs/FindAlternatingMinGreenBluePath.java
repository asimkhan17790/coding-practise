package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
// Leetcode : 1129
public class FindAlternatingMinGreenBluePath {

    public static void main(String[] args) {
        int n = 5;

        //int [][] red_edges = {{0,1},{1,2},{2,3},{3,4}};
        //int [][] blue_edges = {{1,2},{2,3},{3,1}};
        
        //int [][] red_edges = {{2,2},{0,1},{0,3},{0,0},{0,4},{2,1},{2,0},{1,4},{3,4}};
        //{nt [][] blue_edges = {{1,3},{0,0},{0,3},{4,2},{1,0}};

        int [][] red_edges = {{0,1},{1,3},{2,1},{3,1},{2,0},{1,0},{0,2}};
        int [][] blue_edges = {{1,2},{3,2},{2,4},{3,3},{0,3},{1,4},{0,1},{0,2},{0,0},{4,1}};

        int result[] = shortestAlternatingPaths(n, red_edges, blue_edges);
        Arrays.stream(result).forEach(e->System.out.print(e + " "));

    }
    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        
        for (int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for (int i = 0;i<red_edges.length;i++){
            adjList.get(red_edges[i][0]).add(new Node(red_edges[i][1],Color.RED));
        }
        
        for (int i = 0;i<blue_edges.length;i++){
            adjList.get(blue_edges[i][0]).add(new Node(blue_edges[i][1],Color.BLUE));
        }
        
        int [] distance = new int [n];
        Arrays.fill(distance,-1);
        distance[0] = 0;
        
        
        //BFS
        //boolean visited [] = new int[n];
        //Arrays.fill(visited,false);
        //visited[0]=true;
        
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(0, Color.NONE);
        queue.add(root);
        visited.add(root);
        int level = 0;
        while (!queue.isEmpty()){            
            level=level+1;
            int size = queue.size();
            for (int s = 0;s < size;s++){
                Node current = queue.poll();
                for (Node child: adjList.get(current.key)){
                    if (!visited.contains(child) && current.color!=child.color){
                        if (distance[child.key] == -1){
                            // distance[child.key] = distance[current.key] + 1;
                            distance[child.key] = level;
                            // distance[child.key] = Math.min(level,distance[current.key]+1);
                        } 
                        else {
                            // distance[child.key] = Math.min(distance[child.key], distance[current.key] + 1);
                            distance[child.key] = Math.min(distance[child.key], level);
                        }
                        queue.add(child);
                        visited.add(child);
                    }
                }
            }
            
        }               
        return distance;        
    }   
    static Map<Integer,List<Node>>  adjList = new HashMap<>();
    static enum Color {NONE, RED, BLUE};
    static class Node {
        int key;
        Color color;  
        Node(int key, Color color){
            this.key = key;
            this.color = color;
        }
        
        @Override
        public boolean equals(Object o){
            if (!(o instanceof Node)){
                return false;
            }
            Node temp = (Node) o;
            if (temp.key == this.key && temp.color== this.color){
                return true;
            }
                return false;
        }
        public int hashCode() {
            int result = 1;
            result = 37 * result + Objects.hashCode(this.key);        
            return result;
          }
    }
}

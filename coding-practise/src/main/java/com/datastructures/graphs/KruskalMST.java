package com.datastructures.graphs;

import java.util.Arrays;

// Creating Minimum Spanning tree using Kruskal Algorithm
// For Weighted unidirected graph
public class KruskalMST {
    static class Graph {

        class Edge implements Comparable<Edge>{
            int src, dest, weight;

            // Compare edges based on weight
            @Override 
            public int compareTo(Edge compareEdge){
                return this.weight - compareEdge.weight;
            }
        }

        // Class to represent a subset for
        // Union-Find
        class Subset{
            int parent, rank;
        }

        int V,E; // No. of vertices  E-> no. of edges
        Edge edge[];

        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }
        int find(Subset subsets[], int i)
    {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent
                = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
        void Union(Subset[] subsets, int x, int y) {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);

            if (subsets[xroot].rank < subsets[yroot].rank){
                subsets[xroot].parent = yroot;
            } else if (subsets[xroot].rank > subsets[yroot].rank){
                subsets[yroot].parent = xroot;
            } else {
                // Mergin y to x subset
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }
        void KruskalMST() {
            Edge[] result = new Edge[V];
            int e = 0;
            Arrays.fill(result, new Edge());
            Arrays.sort(edge);
            
            Subset subsets[] = new Subset[V];
            for (int i = 0;i < V; i++){
                subsets[i] = new Subset();
            }

            for (int i = 0;i < V; i++){
               subsets[i].parent = i;
               subsets[i].rank = 0;
            }

            int i = 0;
            while(e < V - 1){
                Edge next_edge = edge[i++];
                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);

                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }
             // print the contents of result[] to display
            // the built MST
            System.out.println("Following are the edges in the constructed MST");
            int minimumCost = 0;
            for ( i = 0; i < e; ++i) {
                System.out.println(result[i].src + " -- "
                + result[i].dest
                + " == " + result[i].weight);
                minimumCost += result[i].weight;
            }
            System.out.println("Minimum Cost Spanning Tree " + minimumCost);
            
        }
    }



    // Driver Code
    public static void main(String[] args)
    {
 
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
 
        // Function call
        graph.KruskalMST();
    }

}

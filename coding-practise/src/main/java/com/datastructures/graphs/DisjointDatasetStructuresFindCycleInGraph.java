package com.datastructures.graphs;


// Used for undirected graph only
public class DisjointDatasetStructuresFindCycleInGraph {

    static class Edge
    {
        int src, dest;
    };
 
    static class Graph {
        
        int V, E;    // V-> no. of vertices & E->no.of edges
        Edge edge[]; // /collection of all edges
        Graph(int v,int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i=0; i<e; ++i)
                edge[i] = new Edge();
        }

        boolean isCycle( Graph graph) {
            Subset subsets[] = new Subset[V];
            for (int i = 0;i < V; i++){
                subsets[i] = new Subset();
            }

            for (int i = 0;i < V; i++){
               subsets[i].parent = i;
               subsets[i].rank = 0;
            }
 
            // Iterate through all edges of graph, find subset of both
            // vertices of every edge, if both subsets are same, then
            // there is cycle in graph.
            for (int i = 0; i < graph.E; ++i)
            {
                int x = graph.find(subsets, graph.edge[i].src);
                int y = graph.find(subsets, graph.edge[i].dest);
    
                if (x == y) {
                    return true;
                }                  
                graph.Union(subsets, x, y);
            }
            return false;
        }

        static class Subset {
            int parent;
            int rank;    
        }

        int find(Subset[] subsets, int x){
            if (subsets[x].parent == x){
                return x;
            }
            else {
                subsets[x].parent = find(subsets, subsets[x].parent); // Path Compression technique optimized as topmost parent is now directly stored on this node
            }

            return subsets[x].parent;
        }

        void Union(Subset[] subsets, int x, int y) {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);

            // below code is path compression technique
            if (subsets[xroot].rank < subsets[yroot].rank){
                subsets[xroot].parent = yroot;
            } else if (subsets[xroot].rank > subsets[yroot].rank){
                subsets[yroot].parent = xroot;
            } else {
                // Merging y to x subset
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }
    } 
                            
    // The main function to check whether a given graph
    // contains cycle or not
    
    public static void main(String[] args) {
        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
 
        if (graph.isCycle(graph))
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }  
}

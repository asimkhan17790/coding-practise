package com.datastructures.graphs;

public class DisjointDatasetStructuresFindCycleInGraph {
    public static void main(String[] args) {
        
    }
    class Subset {
        int parent;
        int rank;    
    }

    int find(Subset[] subsets, int x){
        if (subsets[x].parent == x){
            return x;
        }
        else {
            subsets[x].parent = find(subsets, subsets[x].parent);
        }

        return subsets[x].parent;
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
    
}

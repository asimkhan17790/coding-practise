package com.datastructures.graphs;

import java.util.*;

public class FindAllPathsfromSourcetoDestination {
    public static void main(String[] args) {
        FindAllPathsfromSourcetoDestination runner = new FindAllPathsfromSourcetoDestination();
        int[][] ar = {{1,2},{3},{3},{}};
        System.out.println(runner.allPathsSourceTarget(ar));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return Collections.emptyList();
        }

        int n = graph.length;
        if (n == 1) {
            return Collections.singletonList(Collections.singletonList(0));
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Deque<Integer> path = new ArrayDeque<>();
        path.addLast(0);
        
        dfs(0, n - 1, graph, visited, path, result);
        return result;
    }
    
    private void dfs(int current, int target, int[][] graph, boolean[] visited, 
                    Deque<Integer> path, List<List<Integer>> result) {
        if (current == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        visited[current] = true;
        
        for (int neighbor : graph[current]) {
            if (!visited[neighbor]) {
                path.addLast(neighbor);
                dfs(neighbor, target, graph, visited, path, result);
                path.removeLast();
            }
        }
        
        visited[current] = false;
    }
}
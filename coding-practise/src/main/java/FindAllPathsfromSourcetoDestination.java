import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllPathsfromSourcetoDestination {
    

    public static void main(String[] args) {
        FindAllPathsfromSourcetoDestination runner = new FindAllPathsfromSourcetoDestination();

        int ar[][] = {{1,2},{3},{3},{}};
        System.out.println(runner.allPathsSourceTarget(ar));
    }


    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        Graph g = new Graph(n);
        // prepare graph
        for (int i = 0;i < n;i++) {
            for (int j = 0;j<graph[i].length;j++){
                g.addEdge(i,graph[i][j]);
            }
        }
        
        boolean [] visited = new boolean[n];
        Arrays.fill(visited, false);
        List<Integer> path = new ArrayList<>();
        path.add(0);
        DFS(0,n-1,visited,g, path);        
        return paths;
        
    }
    
    void DFS(int source, int destination, boolean[] visited, Graph g, List<Integer> path){
        if (source == destination){            
            paths.add(new ArrayList<>(path));
            return;
        }        
        visited[source] = true;
        
        for (Integer i : g.adjList.get(source)) {
            if (!visited[i]) {                
                path.add(i);
                DFS(i, destination, visited, g, path);
                path.remove(i);
            }
        }
        visited[source] = false;
    }
    
    static class Graph{
        public int V;
        public Map<Integer, List<Integer>> adjList;
        
        Graph(int v){
            this.V = v;
            adjList = new HashMap<>();
            for (int i = 0;i <this.V;i++){
                adjList.put(i, new ArrayList<>());
            }
            
        }
        
        void addEdge(int source, int dest){
            adjList.get(source).add(dest);
        }
    }
}
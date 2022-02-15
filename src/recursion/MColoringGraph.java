package recursion;

import java.util.List;

public class MColoringGraph {

    private static boolean graphColoring(int node, List<Integer>[] graph, int[]color, int n, int m) {
        if(node == n) return true;
        for(int i = 1; i< m; i++) {
            if(isSafe(graph, color, n, i)) {
                color[node] = i;
                if(graphColoring(node+1, graph, color, i, m)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(List<Integer>[] graph, int[] color, int node, int col) {
        for(int it : graph[node]) {
            if(color[it] == col) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

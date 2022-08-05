package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

    public static void bfs(List<List<Integer>> adjList, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i<n; i++) {
            if(visited[i] == false) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    result.add(node);
                    for(int it : adjList.get(node)){
                        if(!visited[it]){
                            queue.add(it);
                            visited[it] = true;
                        }
                    }
                }
            }
        }
        for(Integer i : result){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = GraphUtil.getUndirectedCyclicGraph();
        bfs(adjList, adjList.size());
    }
}

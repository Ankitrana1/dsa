package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUtil {

    //Graphs also contains disconnected components
    /*
                2 --- 3 - 5
              /      /
        0 - 1      /            6  -  7
              \  /               \   /
                4                  8
     */
    public static List<List<Integer>> getUndirectedCyclicGraph() {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<9; i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(1).add(4);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(3).add(4);
        adjList.get(3).add(5);
        adjList.get(4).add(1);
        adjList.get(4).add(3);
        adjList.get(5).add(3);
        adjList.get(6).add(7);
        adjList.get(7).add(6);
        adjList.get(7).add(8);
        adjList.get(8).add(7);

        return adjList;
    }

    public static List<List<Integer>> getUndirectedAcyclicGraph() {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<9; i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(3).add(4);
        adjList.get(3).add(5);
        adjList.get(4).add(3);
        adjList.get(5).add(3);
        adjList.get(6).add(7);
        adjList.get(7).add(6);
        adjList.get(7).add(8);
        adjList.get(8).add(7);

        return adjList;
    }

    public static List<List<Integer>> getUndirectedCyclicGraphWithOddLength() {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=9; i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(1).add(9);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(3).add(4);
        adjList.get(3).add(5);
        adjList.get(4).add(9);
        adjList.get(4).add(3);
        adjList.get(5).add(3);
        adjList.get(6).add(7);
        adjList.get(7).add(6);
        adjList.get(7).add(8);
        adjList.get(8).add(7);
        adjList.get(9).add(1);
        adjList.get(9).add(4);

        return adjList;
    }

    public static List<List<Integer>> getDirectedCyclicGraph() {
        //ToDo implement list and return directed cyclic graph
        return null;
    }

    public static List<List<Integer>> getDirectedAcyclicGraph() {
        //ToDo implement list and return directed Acyclic graph
        return null;
    }
}

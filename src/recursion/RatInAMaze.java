package recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    /*
    Print all possible solution for the problem in lexicographical order.
    Rat can move - Down, Up , Right, and Left.
    Can visit path once in a solution.
     */

    private static void solve(int i, int j, List<String> res, boolean[][] visited,
                              int[][] maze, String move, int[] di, int[] dj, int n) {
        if(i == n-1 && j == n-1) {
            res.add(move);
            return;
        }
        String dir = "DLRU";
        for(int index = 0; index<4; index++) {
            int nextI = i+di[index];
            int nextJ = j+dj[index];
            if(nextI >=0 && nextJ >=0 && nextI<n && nextJ<n && !visited[nextI][nextJ] && maze[nextI][nextJ]==1) {
                visited[nextI][nextJ] = true;
                solve(nextI, nextJ, res, visited, maze, move+dir.charAt(index), di, dj, n);
                visited[nextI][nextJ] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0}, {1,1,0,1}, {1,1,0,0}, {0,1,1,1}};
        List<String> res = new ArrayList<>();
        int[] di = {1,0,0,-1};
        int[] dj = {0,-1,1,0};

        solve(0,0, res, new boolean[maze.length][maze.length], maze, "", di, dj, maze.length);

        for(String s : res){
            System.out.println(s);
        }

    }
}

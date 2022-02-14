package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NQueen {

    private static boolean isSafe(int row, int col, List<String> board) {
        int dupRow = row;
        int dupCol = col;
        while(row >= 0 && col >= 0){
            if(board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(col>=0) {
            if(board.get(row).charAt(col) == 'Q') return false;
            col--;
        }
        col = dupCol;
        while(row < board.size() && col >= 0){
            if(board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    private static void nQueen(int col, List<List<String>> ans, List<String> board, int n) {
        if (col == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0; row <n; row++) {
            if(isSafe(row, col, board)) {
                ((ArrayList)board).set(row, board.get(row).substring(0, col) + 'Q' + board.get(row).substring(col+1));
                nQueen(col+1, ans, board, n);
                ((ArrayList)board).set(row, board.get(row).substring(0, col) + '.' + board.get(row).substring(col+1));
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        int n = 5;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
            sb.append(".");
        }
        List<String> board = new ArrayList<>(Collections.nCopies(n, sb.toString()));

        nQueen(0, ans, board, n);

        for(List<String> a  :ans) {
            for(String s : a){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}

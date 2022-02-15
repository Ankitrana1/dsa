package recursion;

public class SodukoSolver {

    public static boolean solveSudoku(char[][] board) {
        for(int i = 0; i<board.length; i++) {
            for(int j =0; j<board[0].length; j++) {

                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solveSudoku(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //remove unnecessary double for loop
    private static boolean solveSudoku2(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // reach the last column, next row
            return solveSudoku2(board, i + 1, 0);
        }
        if (i == m) {
            // reach the last row, finish
            return true;
        }

        if (board[i][j] != '.') {
            // preset number, skip
            return solveSudoku2(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // conflict with others, skip
            if (!isValid(board, i, j, ch))
                continue;

            board[i][j] = ch;
            // have found a solution, stop
            if (solveSudoku2(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // for this grid, 1~9 all fail
        return false;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for(int i =0; i<9; i++) {
            if(board[i][col] == c) return false;
            if(board[row][i] == c) return false;
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        print(board);
        System.out.println();
        char[][] board2 = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku2(board2, 0,0);
        print(board2);
    }

    private static void print(char[][] board) {
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }
}

// https://leetcode.com/problems/n-queens

class Solution {
    private ArrayList<List<String>> solutions = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        recur (board, n);
        return solutions;
    }

    private void recur(boolean[][] board, int n)
    {
        if(n == 0)
        {
            addToSol(board);
            return;
        }
        int row = board.length - n;//
        for(int col = 0; col < board.length; col++)
        {
            if(check(board, row, col)) //in line of sight
            {
                board[row][col] = true; //a queen is there
                recur(board, n-1);
                board[row][col] = false;
            }
        }
    }

    private boolean check(boolean[][] board, int row, int col){
        for(int i = 0; i < board.length; i++)
        {
            if(i!= col && board[row][i])
                return false;
            if(i!= row && board[i][col])
                return false;
            if(i!= row && row + col - i >= 0 && row + col - i < board.length && board[i][row + col - i])
                return false;
            if(i!= row && col-row + i >= 0 && col-row + i < board.length && board[i][col-row + i])
                return false;

        }
        return true;
    }

    private void addToSol(boolean[][] board)
    {
        ArrayList<String> sol = new ArrayList<String>();
        for(int i = 0; i < board.length; i++)
        {
            String line = "";
            for(int j = 0; j < board.length; j++)
                line+=board[i][j] ? 'Q' : '.';
            sol.add(line);
        }
        solutions.add(sol);
            
    }
}
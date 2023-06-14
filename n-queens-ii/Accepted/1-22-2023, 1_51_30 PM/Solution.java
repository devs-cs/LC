// https://leetcode.com/problems/n-queens-ii

class Solution {
    private int sol = 0;
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        recur (board, n);
        return sol;
    }

    private void recur(boolean[][] board, int n)
    {
        if(n == 0)
        {
            sol++;
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
}
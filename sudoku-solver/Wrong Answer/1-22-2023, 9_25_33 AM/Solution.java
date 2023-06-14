// https://leetcode.com/problems/sudoku-solver

class Solution { 
    public void solveSudoku(char[][] board) {
        ArrayList<Integer>[][] pos = new ArrayList[9][9];
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                pos[i][j] = new ArrayList<Integer>();
        int missing = 0;
        for(int row = 0; row < 9; row++)
        {
            for(int col = 0; col < 9; col++)
            {
                if(board[row][col] == '.')
                {
                    missing++;
                    for(int test = 1; test <= 9; test++)
                    {
                        if(check(row, col, test, board))
                            pos[row][col].add(test);
                    }
                }
            }
        }

        int lastMissing = 0;
        int secondLastMissing = 0;
        while(missing > 0)
        {   
            secondLastMissing = lastMissing;
            lastMissing = missing;
            if (missing == secondLastMissing)
                break;
            
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                {
                    for(int num = 0; num < pos[i][j].size(); num++)
                    {
                        if(!check(i, j, pos[i][j].get(num), board)) //check and if a number is no longer a possibility, remove it
                        {
                            // System.out.println("REMOVE POSSIBILITY: " + pos[i][j].get(num) + " at " + i + "," + j);
                            pos[i][j].remove(num);
                        }
                    }
                    if(pos[i][j].size() == 1)
                    {
                        
                        board[i][j] = (char) (pos[i][j].get(0) + '0');
                        // System.out.println("DECISION: " + board[i][j] + " at " + i + "," + j);
                        missing--;
                        pos[i][j].remove(0);
                    }
                        
                }
            }
        }
        
    }

    private boolean check(int row, int col, int test, char[][] board)
    {
         
        for(int i = 0; i < 9; i++)
        {
            // System.out.println(i + " " + col);
            if(board[i][col] - '0' == test)
                return false;
            // System.out.println(col + " " + i);
            if (board[row][i] - '0' == test)
                return false;
        }
       
        int cornerRow = row/3 * 3;
        int cornerCol = col/3 * 3;
        for(int i = cornerRow; i < cornerRow + 3; i++)
        {
            for(int j = cornerCol; j < cornerCol+3; j++)
            {
                if(board[i][j] - '0' == test)
                    return false;
            }
        }
        return true;
    }
}
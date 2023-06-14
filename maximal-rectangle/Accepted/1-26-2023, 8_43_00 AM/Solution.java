// https://leetcode.com/problems/maximal-rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // int[][][] rectDim = new int[n][m][2]; //the 2 at the end are for the length and width of longest rectange
        int curMax = 0;
        int[][] rowOnes = new int[n][m];
        for(int row = 0; row < n; row++)
        {
            int curOnes = 0;
            for(int col =0; col < m; col++)
            {
                if(matrix[row][col] == '1')
                    curOnes++;
                else
                    curOnes = 0;
                rowOnes[row][col] = curOnes;
            }
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                int curMin = 1000000;
                for(int height = 0; i - height>= 0; height++)
                {
                    curMin = Math.min(curMin, rowOnes[i-height][j]);
                    curMax = Math.max(curMax, (height+1) * curMin);
                }
            }
        }
        return curMax;  
    }
}



/*
 for(int i = 0; i < n; i++)
        {
            if(matrix[i][0] == '1')
            {
                rectDim[i][0][0] = 1;
                rectDim[i][0][0] = 1;
            }
        }
        for(int i = 0; i < m; i++)
        {
            if(matrix[0][i] == '1')
            {
                rectDim[0][i] = 1;
                rectDim[0][i] = 1;
            }
        }
        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                int opt1 = Math.
            }
        }

        */
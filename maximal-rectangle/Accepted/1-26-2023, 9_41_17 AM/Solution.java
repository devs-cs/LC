// https://leetcode.com/problems/maximal-rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] height = new int[n][m];
        int curMax = 0;
        //so each rectangle needs to have a least height that works, similar to the last problem, so first lets establish heights
        for(int col = 0; col < m; col++)
        {
            int count = 0;
            for(int row = 0; row < n; row++)
            {
                if(matrix[row][col] == '1')
                    count++;
                else
                    count=0;
                height[row][col] = count;
            }
        } //so height stores how many ones are above a certain number, now we want to store left and right, where left is the left smaller element and right is the right smaller element

        int[][] right = new int[n][m];
        int[][] left = new int[n][m];
        //so we can use a stack
        for(int i = 0; i < n; i++)
        {
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j < m; j++)
            {
                 if (stack.empty() || height[i][j] >= height[i][stack.peek()])
                    stack.push(j); //col is only thing that matters
                else
                {
                    while(!stack.empty() && height[i][stack.peek()] > height[i][j])
                    {
                        int col = stack.pop();
                        right[i][col] = j-1;
                    }
                    stack.push(j); 
                }
             }
             while(!stack.empty())
             {
                int col = stack.pop();
                right[i][col] = m-1;
             }
        }
        for(int i = 0; i < n; i++)
        {
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = m-1; j>=0 ; j--)
            {
                 if (stack.empty() || height[i][j] >= height[i][stack.peek()])
                    stack.push(j); //col is only thing that matters
                else
                {
                    while(!stack.empty() && height[i][stack.peek()] > height[i][j])
                    {
                        int col = stack.pop();
                        left[i][col] = j+1;
                    }
                    stack.push(j); 
                }
             }
             while(!stack.empty())
             {
                int col = stack.pop();
                left[i][col] = 0;
             }
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                curMax = Math.max(curMax, (right[i][j] - left[i][j] + 1) * height[i][j]);
        }




        if(right.length >= 3) System.out.println(Arrays.toString(right[2]));
        if(right.length >= 3) System.out.println(Arrays.toString(left[2]));
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
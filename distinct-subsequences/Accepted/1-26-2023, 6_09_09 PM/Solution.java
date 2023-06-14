// https://leetcode.com/problems/distinct-subsequences

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] arr = new int[m][n];

        char newChar1 = t.charAt(m - 1);//
        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == newChar1)
                arr[0][i] = 1;
        }

        for(int i = 1; i < m; i++)
        {
            char newChar = t.charAt(m - i - 1);//
            int count = 0;
            for(int j = n-1; j>= 0; j--)
            {
                if(s.charAt(j) == newChar)
                    arr[i][j] = count;
                count+= arr[i-1][j];
                
            }
        }

        for(int i = 0; i < m; i++)
        {
            System.out.println(Arrays.toString(arr[i]));
        }
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum+= arr[m-1][i];
        return sum;
    }
}
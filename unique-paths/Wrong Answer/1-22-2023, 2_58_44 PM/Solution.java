// https://leetcode.com/problems/unique-paths

class Solution {
    public int uniquePaths(int m, int n) {
        m = m-1;
        n = n-1;
        int temp = m;
        m = Math.max(m, n);
        n = Math.min(temp, n);    
        long factN = 1, factMN = 1;
        for(int i = m+1; i <= m+n; i++)
        {
            if (factN % i == 0)
                factN = factN/i;
            else
                factMN *= i;
            factN *= (i-m);
        }
        return((int)factMN/(int)factN);
    }
}
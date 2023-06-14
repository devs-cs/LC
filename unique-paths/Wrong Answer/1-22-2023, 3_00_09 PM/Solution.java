// https://leetcode.com/problems/unique-paths

class Solution {
    public int uniquePaths(int m, int n) {
        m = m-1;
        n = n-1;
        int temp = m;
        m = Math.max(m, n);
        n = Math.min(temp, n);    
        double ans = 1;
        for(int i = m+1; i <= m+n; i++)
        {
            ans *= i/(i-m);
        }
        return((int)Math.round(ans));
    }
}
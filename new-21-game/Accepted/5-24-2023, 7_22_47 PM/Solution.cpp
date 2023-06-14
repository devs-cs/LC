// https://leetcode.com/problems/new-21-game

class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        if(k == 0 && n != 0) return 1;
        if(k + maxPts - 1 <= n) return 1;
        double odds[10001] = {};
        
        odds[0] = 1;
        double curSum = 1.0/maxPts;
        odds[1] = curSum;
        for(int i = 2; i <= k; i++)
        {
            if(i <= maxPts)
                curSum += odds[i-1] * 1.0/maxPts;
            else
                curSum += odds[i-1] * 1.0/maxPts - odds[i - maxPts-1] * 1.0/maxPts;
            odds[i] = curSum;
        }
        curSum = 0;

        for(int j = max(0, k+1 - maxPts); j < k; j++)
               curSum += odds[j];
        curSum *=  1.0/maxPts;
        odds[k+1] = curSum;

        for(int i = k+2; i <= n; i++)
        {
            if(i > maxPts)
                curSum -= odds[i - maxPts-1] * 1.0/maxPts;
            odds[i] = curSum;
        }
        double sol = 0;
        for(int i = k; i <= n; i++)
            sol += odds[i]; 
        return sol;
        
    }
};
// https://leetcode.com/problems/new-21-game

class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
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
        
        for(int i = k+1; i <= n; i++)
        {
            for(int j = max(0, i - maxPts); j < k; j++)
                odds[i] += odds[j];
            odds[i] *= 1.0/maxPts; 
        }
        double sol = 0;
        for(int i = k; i <= n; i++)
            sol += odds[i]; 
        return sol;
        
    }
};
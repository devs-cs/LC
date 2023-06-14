// https://leetcode.com/problems/new-21-game

class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        double odds[10001] = {};
        
        odds[0] = 1;
        for(int i = 1; i <= k; i++)
        {
            for(int j = max(0, i - maxPts); j <i; j++)
                odds[i] += odds[j];
            odds[i] *= 1.0/maxPts; //could do all the multiplication at the end
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
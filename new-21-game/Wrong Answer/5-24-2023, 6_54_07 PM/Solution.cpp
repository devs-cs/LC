// https://leetcode.com/problems/new-21-game

class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        if(n <= k) return 1;
        vector<double> odds(n+1, 0.0);
        odds[0] = 1;
        for(int i = 1; i <= k; i++)
        {
            for(int j = max(0, i - maxPts); j <i; j++)
                odds[i] += odds[j] * 1.0/maxPts; //could do all the multiplication at the end
        }
        for(int i = k+1; i <= n; i++)
        {
            for(int j = max(0, i - maxPts); j < k; j++)
                odds[i] += odds[j] * 1.0/maxPts; 
        }
        double sol = 0;
        for(int i = k; i <= n; i++)
            sol += odds[i]; 
        return sol;
        
    }
};
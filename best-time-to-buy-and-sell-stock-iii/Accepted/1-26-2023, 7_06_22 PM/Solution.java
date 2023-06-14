// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii

class Solution {


    //we basically want a max and min seg-tree
    public int maxProfit(int[] prices) {
    
        int n = prices.length;
        /*
        we can easily calculate the profit from the first sell, then how do we calc the profit from the second sell
        , actually find the largest jump after a point by going backwards
        */
        int[] gap = new int[n];
        int minVal = prices[0];
        gap[0] = 0;
        for(int i = 1; i < n; i++)
        {
            minVal = Math.min(minVal, prices[i]);
            gap[i] = Math.max(gap[i-1], prices[i] - minVal); //largest gap before i 
        }
        int[] revGap = new int[n];
        revGap[n-1] = 0;
        int max = prices[n-1];
        for(int i = n-2; i >=0; i--)
        {
            max = Math.max(prices[i], max);
            revGap[i] = Math.max(max - prices[i], revGap[i+1]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, gap[i] + revGap[i]);
        return ans;        
    }
}
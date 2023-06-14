// https://leetcode.com/problems/minimum-average-difference

class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            sum += nums[i];
        }
        double minDist = Math.abs(sum)/(1.0 * n);
        int minDistIndex = n-1;
        int s1 = 0;
        int s2 = sum;
        for(int i = 0; i < n-1; i++)
        {
            s1 += nums[i];
            s2 -= nums[i];
            if(Math.abs(s1/(1.0 * (i+1)) - s2/(n-(i+1))) < minDist)
            {
                minDist = Math.abs(s1/(1.0 * (i+1)) - s2/(n-(i+1)));
                minDistIndex = i;
            }
        }
        return minDistIndex;
                                   
    }
}
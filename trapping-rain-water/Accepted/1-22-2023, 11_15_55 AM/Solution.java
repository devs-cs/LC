// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++)
            max = Math.max(height[i], max);
        int[] firstReach = new int[max+1];
        Arrays.fill(firstReach, 10000);
        int[] lastReach = new int[max+1];
        for(int i = 0; i < height.length; i++)
        {
            if(firstReach[height[i]] == 10000)
                firstReach[height[i]] = i;
            lastReach[height[i]] = i;
        }
        for(int i = max-1; i >= 0; i--)
        {
                firstReach[i] = Math.min(firstReach[i+1], firstReach[i]);
                lastReach[i] = Math.max(lastReach[i+1], lastReach[i]);
        }

        //use prefix sums to count how many buildings surpass a certain height
        
        int[] reachN = new int[max+1];
        for(int i = 0; i < height.length; i++)
            reachN[height[i]]++;
        for(int i = max-1; i>=0; i--)
            reachN[i] += reachN[i+1]; //now it represents how many people meet or exceed that height, let's test it out
        // System.out.println(Arrays.toString(reachN));

        int output = 0;
        for(int i = 1; i <= max;i++)
            output += lastReach[i] - firstReach[i] + 1 - reachN[i];
        return output;
    }
}
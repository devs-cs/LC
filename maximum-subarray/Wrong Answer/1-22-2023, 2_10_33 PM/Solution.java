// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        for(int i = 1; i <= n; i++)
            preSum[i] = preSum[i-1] + nums[i-1];
        int[] minSum = new int[n+1];
        int[] minSumIndex = new int[n+1];
        for(int i = 1; i <= n; i++)
        {
            if(minSum[i-1] < preSum[i])
            {
                minSum[i] = minSum[i-1];
                minSumIndex[i] = minSumIndex[i-1];
            }
            else
            {
                minSum[i] = preSum[i];
                minSumIndex[i] = i;  //index after subarray with minIndex or something like that 
            }
        }
        int maxIndex = 0;
        for(int i = 0; i <= n; i++)
        {
            if(preSum[i] - preSum[minSumIndex[i]] > preSum[maxIndex] - preSum[minSumIndex[maxIndex]])
                maxIndex = i;
        } 
        // System.out.println(Arrays.toString(preSum));
        // System.out.println(Arrays.toString(minSumIndex));
        // System.out.println(minSumIndex[maxIndex] + " " + maxIndex);
        return(preSum[maxIndex] - preSum[minSumIndex[maxIndex]]);    
    }
}
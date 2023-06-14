// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int[] store = new int[20001]; // might need to use sorting tricks to compactify numbers into range of 1 to 2500
        int minNum = 10001;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] < minNum)
                minNum = nums[i];
        for(int i = 0; i< nums.length;i++)
            nums[i] = nums[i] - minNum;
        for(int i = nums.length - 1; i >=0; i--)
        {
            int max = 0;
            for(int j = nums[i]+1; j < store.length;j++)
            {
                if(store[j] > max)
                    max = store[j];
            }
            if(max + 1 > store[nums[i]])
                store[nums[i]] = max+1;
        }
        int sol = 0;
        for(int i = 0; i < store.length; i++)
        {
            if(store[i] > sol)
                sol = store[i];
        }
        return(sol);
    
    }
}
// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) { 
        if(nums.length == 1)
        {
           return;
        }
        int sml = nums.length -2;
        while(sml >= 0 && nums[sml] >= nums[sml+1])
            sml--;
        if(sml == -1 && nums[0] >= nums[1])
        {
            Arrays.sort(nums);
            return;
        }
        //now the new order is secondSmallest, smallest, other numbers
        int sndSml;
        for(sndSml = nums.length-1; sndSml >= 0 && nums[sndSml] <= nums[sml]; sndSml--);
        int temp = nums[sml];
        nums[sml] = nums[sndSml];
        nums[sndSml] = temp;
        Arrays.sort(nums, sml+1, nums.length);

    }
}


/*
 1 7 4  -    6 8 7 54  ,  




*/
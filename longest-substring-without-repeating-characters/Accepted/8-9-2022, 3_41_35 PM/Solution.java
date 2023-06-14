// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] subAt = new int[s.length()];//this stores the longest substring that ends at I
        if(s.length() == 0)
            return(0);
        subAt[0] = 1;
        int curStart = 0;
        for(int i = 1; i < s.length(); i++)
        {
            //boolean add = true;
            for(int j = curStart; j < i; j++)
            {
                if(s.substring(j, j+1).equals(s.substring(i, i+1)))
                {
                    
                    curStart = j + 1;
                    break;
                }
            }
            subAt[i] = i - curStart + 1;
            //System.out.println(curStart + " " + subAt[i]);
        }
        int max = 0;
        for(int i = 0; i < s.length(); i++)
            if(subAt[i] > max)
                max = subAt[i];
        return(max);
    }
}
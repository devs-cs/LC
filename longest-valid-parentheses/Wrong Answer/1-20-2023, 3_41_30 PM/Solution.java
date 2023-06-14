// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        
        int max = 0;
       
        for(int pos = 0; pos < s.length(); pos++)
        {
            int temp = pos;
            int curOpen = 0; 
            int curLength = 0;
            while(pos < s.length())
            {
                curLength++;
                if (s.charAt(pos) == '(')
                    curOpen++;
                else
                    curOpen--;
                if(curOpen == 0)
                    max = Math.max(max, curLength);
                if (curOpen < 0)
                    curLength = 0;
                pos++;
            }
            pos = temp;
        }
        return max;
    }
}
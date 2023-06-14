// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        String val = "1";
        for(int i = 1; i < n; i++)
            val = countAndSayCalc(val);
        return val;
    }

    private String countAndSayCalc(String n)
    {
        String output = "";
        int curCount = 0;
        int lastDigit = Integer.parseInt(n.substring(0, 1));
        int digit = -1;
        for(int i = 0; i < n.length(); i++)
        {
            digit = Integer.parseInt(n.substring(i, i+1));
            curCount++;
            if(digit != lastDigit)
            {
                output += "" + (curCount-1) + lastDigit;
                lastDigit = digit;
                curCount = 1;
            }  
        }
        output += "" + (curCount) + digit;
        return output;
    }
}
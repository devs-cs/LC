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
        StringBuilder output = new StringBuilder();
        int curCount = 0;
        int lastDigit = Integer.parseInt(n.substring(0, 1));
        int digit = -1;
        for(int i = 0; i < n.length(); i++)
        {
            digit = Integer.parseInt(n.substring(i, i+1));
            curCount++;
            if(digit != lastDigit)
            {
                output.append("" + (curCount-1) + lastDigit);
                lastDigit = digit;
                curCount = 1;
            }  
        }
        output.append("" + (curCount) + digit);
        return output.toString();
    }
}
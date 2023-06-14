// https://leetcode.com/problems/divide-two-integers

class Solution {
    public int divide(int dividend, int divisor) {
        boolean pos = !((dividend <= 0) ^ (divisor <= 0));
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = 0;
        int i = 0;
        for(i = 0; sum <= dividend; i++)
            sum+= divisor;
        if(pos)
            return(i-1);
        else
            return(-(i-1));
            
    }
}
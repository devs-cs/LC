// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right)
        {
            while(left < s.length() && (!alpha(s.charAt(left)) && !(s.charAt(left) >= '0' && s.charAt(left) <= '9')))
            {
                // System.out.println(s.charAt(left) >= '1' && s.charAt(left) <= '9');
                left++;
                
            } 
            while(right >=0 && (!alpha(s.charAt(right)) && !(s.charAt(right) >= '0' && s.charAt(right) <= '9')))
                right--;
            if (left >= right)
                return true;
            if(s.charAt(left) == s.charAt(right) || (alpha(s.charAt(left)) && alpha(s.charAt(right)) && Math.abs(s.charAt(left) - s.charAt(right)) == 'a' - 'A'))
            {
                //  System.out.println("ERROR " + s.charAt(left) + " " + s.charAt(right));
                left++;
                right--;
            }
            else 
            {
                System.out.println(left + " " + right);
                return false;
            }
        }
        return true;
    }

    private boolean alpha(char let)
    {
        return(('A' <= let && let <= 'Z') || ('a' <= let && 'z' >= let));
    }
}
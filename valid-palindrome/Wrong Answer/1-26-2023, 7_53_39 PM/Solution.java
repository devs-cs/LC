// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right)
        {
            while(left < s.length() && !alpha(s.charAt(left)))
                left++;
            while(right >=0 && !alpha(s.charAt(right)))
                right--;
            if (left >= right)
                return true;
            if(s.charAt(left) == s.charAt(right) || Math.abs(s.charAt(left) - s.charAt(right)) == 'a' - 'A')
            {
                left++;
                right--;
            }
            else 
            {
                // System.out.println(left + " " + right);
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
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        LinkedList<Character> key = new LinkedList<Character>();
        LinkedList<Character> word = new LinkedList<Character>();
        for(int i = 0; i < needle.length(); i++)
        {
            word.add(haystack.charAt(i));
            key.add(needle.charAt(i));
        }
        if (needle.equals(haystack.substring(0, needle.length())))
            return 0;
        for(int i = needle.length(); i < haystack.length(); i++)
        {
            word.remove();
            word.add(haystack.charAt(i));
            if(word.hashCode() == key.hashCode())
            {
                if (needle.equals(haystack.substring(i-needle.length(), needle.length())))
                    return(i - needle.length());
            }
        
        }
        return -1;
    }
       
}
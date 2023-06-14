// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length())
            return -1;
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
            if(true)
            {
                if (needle.equals(haystack.substring(i-needle.length()+1,i+1)))
                    return(i - needle.length()+1);
            }
        
        }
        return -1;
    }
       
}
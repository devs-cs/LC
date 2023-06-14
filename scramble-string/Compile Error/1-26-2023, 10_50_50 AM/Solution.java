// https://leetcode.com/problems/scramble-string

class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        if(n == 2 && s1.charAt(0) == s2.charAt(1) && s2.charAt(0) == s1.charAt(1));
            return true;
        if (n== 3)
        {
            if(s1.equals("" + s2.charAt(1)  + s2.charAt(0) + s2.charAt(2)))
                return true;
            else if (s1.equals("" + s2.charAt(2)  + s2.charAt(0) + s2.charAt(1)))
                return true;
            else if (s1.equals("" + s2.charAt(2)  + s2.charAt(1) + s2.charAt(0)))
                return true;
            return false;
        }
        boolean found = false;
        
        int[] counts1 = new int[26];
        int[] revCounts1 = new int[26];
        int[] counts2 = new int[26];
        int letter = 0;
   

        for(int i = 0; i < n-1; i++)
        {
            letter++;
            counts1[s1.charAt(i) - 'a']++;
            revCounts1[s1.charAt(n - i-1) - 'a']++;
            counts2[s2.charAt(i) - 'a']++;
            if (compare(counts1, counts2))
            {
                boolean works = true;
                works &= isScramble(s1.substring(0, letter), s2.substring(0, letter));
                works &= isScramble(s1.substring(letter, n), s2.substring(letter, n));
                if (works)
                {
                    // System.out.println(s1 + " " + s2 + " true");
                    return true;
                }     
            }
            if (compare(counts2, revCounts1))
            {
                boolean works = true;
                works &= isScramble(s1.substring(n- letter,n), s2.substring(0, letter));
                works &= isScramble(s1.substring(0, n-letter), s2.substring(letter, n));
                // System.out.println("HIT " + s1.substring(n- letter,n)+ " " + s2.substring(0, letter));
                // System.out.println("HIT2 " + s1.substring(0, n-letter)+ " " + s2.substring(letter, n));
                if (works)
                {
                    // System.out.println(s1 + " " + s2 + " true");
                    return true;
                }
            }
        }
        // System.out.println(s1 + " " + s2 + " false");
        return false;
    }

    private boolean compare(int[] arr1, int[] arr2)
    {
        for(int i = 0; i < arr1.length; i++)
        {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    
}
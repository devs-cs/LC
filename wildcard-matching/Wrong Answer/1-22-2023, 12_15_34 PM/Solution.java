// https://leetcode.com/problems/wildcard-matching

class Solution {
    public boolean isMatch(String s, String p) {
        String[] subP = p.split("\\*");
        System.out.println(Arrays.toString(subP));
        int index = 0;
        if(subP.length == 0)
            return true;
        if(subP[0].length() != 0)
        {
            if(!check(s.substring(0, subP[0].length()), subP[0]))
                return false;;
        }
        int n = subP.length;
        if (subP[n-1].length() != 0 )
        {
            String substring = s.substring(s.length() - subP[n-1].length(), s.length());
            if(!check(substring, subP[n-1]))
                return false;
        }
        System.out.println("Got here");
        for(int i = 1; i < n-1; i++) //we are not checking the first and last because we just did that
        {
            if (subP[i].length() == 0) //just means **
                continue;
            index = baseMatch(index, s, subP[i]);
            if(index == -1)
                return false;
        }
        return true;

    }

    private int baseMatch(int index, String s, String p){ //this checks whether a substring starting after index matches a pattern with no *
        int size = p.length();
        for(int start = index; start + size< s.length(); start++)
        {
            String region = s.substring(start, start + size);
            if(check(region, p))
                return start + size;
        }
        return -1;
    }

    private boolean check(String s, String p)
    {
        if(p.length() != s.length())
            return false;
        for(int i = 0; i < s.length(); i++)
        {
            if(p.charAt(i) == '?')
                continue;
            if(p.charAt(i) != s.charAt(i))
                return false;
        }
        return true;
    }

}
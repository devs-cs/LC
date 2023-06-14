// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int cur = convert(s.substring(i, i+1));
            boolean adding = true;
            int search = 1;
            boolean notSmaller = true;
            int pastCur = -1;
            boolean pastAdd = true;
            while(adding && i + search < s.length() && notSmaller)
            {
                if(convert(s.substring(i+ search, i + search + 1)) > cur)
                    adding = false;
                else if(convert(s.substring(i+ search, i + search + 1)) < cur)
                    notSmaller = false;
                else if(pastCur == cur)
                    notSmaller = false;
                search++;
            }
            pastCur = cur;
            pastAdd = adding;
            if(adding)
                sum+= cur;
            else
                sum-= cur;
        }
        return(sum);
    }
    
    public int convert(String s)
    {
        if(s.equals("M"))
            return(1000);
        else if (s.equals("D"))
            return(500);
        else if (s.equals("C"))
            return(100);
        else if(s.equals("L"))
            return(50);
        else if(s.equals("X"))
            return(10);
        else if(s.equals("V"))
            return(5);
        else 
            return(1);
    }  
    
}
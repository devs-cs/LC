// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int[] arr = new int[s.length()];
        for(int j = 0; j < s.length(); j++)
            arr[j] =  convert(s.substring(j, j+1));
        for(int i = 0; i < s.length(); i++)
        {
            
            boolean adding = true;
            int search = 1;
            boolean notSmaller = true;
            int pastCur = -1;
            boolean pastAdd = true;
            while(adding && i + search < s.length() && notSmaller)
            {
                if(arr[i+search] > arr[i])
                    adding = false;
                else if(arr[i+search+1] < arr[i])
                    notSmaller = false;
                else if(i != 0 && arr[i] == arr[i-1])
                {
                    adding = pastAdd;
                    notSmaller = false;
                }
                    search++;
            }
            pastAdd = adding;
            if(adding)
                sum+= arr[i];
            else
                sum-= arr[i];
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
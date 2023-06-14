// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needed = new HashMap<>();
        int stores = 0;
        int front = 0;
        boolean cont = true;
        int end = -1;
        int[] shortest = new int[s.length()];//shortest[i] is shortest substring that ends at index i
        for(int i = 0; i < t.length(); i++)
        {
            if(needed.containsKey(t.charAt(i)))
            {
                needed.put(t.charAt(i), needed.get(t.charAt(i))+1);
               
            }
                
            else
            {
                 needed.put(t.charAt(i), 1);
            }
               
        }
        
        
        while(stores<t.length())
        {
            end++;
            if(end >=s.length())
                return "";
            if(needed.containsKey(s.charAt(end)))
            {
                if(needed.get(s.charAt(end)) > 0)
                    stores++;
                needed.put(s.charAt(end),needed.get(s.charAt(end)) -1);
            }
        }
        if(stores < t.length() && end == s.length())
            return("");
        
        while(!needed.containsKey(s.charAt(front)) || needed.get(s.charAt(front)) < 0 && front <= end)
        {
            if(needed.containsKey(s.charAt(front)))
               needed.put(s.charAt(front),needed.get(s.charAt(front)) +1);
            front++;
        }
               
        for(int i = 0; i < end; i++)
               shortest[i] = -1;
        shortest[end] = front;
        for(int i = end+1; i < s.length(); i++)
        {
            if(needed.containsKey(s.charAt(i)))
                needed.put(s.charAt(i),needed.get(s.charAt(i)) -1);
            //System.out.println("C Sit: " + needed.get('c'));
            while(!needed.containsKey(s.charAt(front)) || needed.get(s.charAt(front)) < 0)
            {
                
                if(needed.containsKey(s.charAt(front)))
                {
                    //System.out.println("UPDATE FRONT:" + s.charAt(front));
                     needed.put(s.charAt(front),needed.get(s.charAt(front)) +1);
                }
                front++;
                  
            }
            shortest[i] = front;
            //System.out.println(front + " " + i + " " + needed.get('B'));
        }
        //System.out.println(front + " " + end + " " + needed.get('C'));
        /*for(int i = 0; i < s.length(); i++)
            System.out.print(shortest[i] + " ");*/
        int maxIndex = -1;
        for(int i = 0; i < s.length(); i++)
        {
            if(shortest[i] !=-1 && (maxIndex == -1 || i-shortest[i] < maxIndex - shortest[maxIndex]))
                maxIndex = i;
        }
        
        //ADOBECO
        
        return s.substring(shortest[maxIndex], maxIndex+1);
    }
}
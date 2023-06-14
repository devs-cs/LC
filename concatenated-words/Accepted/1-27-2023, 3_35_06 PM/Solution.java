// https://leetcode.com/problems/concatenated-words

class Solution {
    private HashMap<String, Boolean> memWords = new HashMap<String, Boolean>();
    private HashMap<String, Boolean> memCombo = new HashMap<String, Boolean>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> answer = new ArrayList<String>();
        for(int i = 0; i < words.length; i++)
            memWords.put(words[i], true);
        for(int i = 0; i < words.length; i++)
        {
            if(isValid(words[i], words, 0))
                answer.add(words[i]);
        }
        return answer;

    }

    private boolean isValid(String s, String[] words, int count) //count refers to amount of words we have so far
    {
        // System.out.println(s + " " + count);
        if (count > 0 && memWords.containsKey(s))
            return true;
        if (memCombo.containsKey(s))
            return memCombo.get(s);
        String test = "";
        for(int i = 0; i < s.length()-1; i++)
        {
            test+=s.charAt(i);
            if (memWords.containsKey(test))
            {
                
                String newWord = s.substring(i+1, s.length());
               
                boolean val = isValid(newWord, words, count+1);
                if(!memCombo.containsKey(newWord) && !memWords.containsKey(newWord))
                    memCombo.put(newWord, val);
                //  System.out.println(s + " " + newWord + " " + val);
                if(val)
                    return val;
            }
        }
        return false;
    }

}
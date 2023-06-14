// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashSet wordsSet = new HashSet<String>();
        ArrayList solutions = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++)
        {
            if(!wordsSet.contains(words[i]))
                wordsSet.add(words[i]);
        }
        // System.arraycopy(wordsSet.toArray(), 0, words, 0, wordsSet.size());
        int wordLen = words[0].length();
        for(int shift = 0; shift < wordLen; shift++) //will need to consider all possible frameshifts
        {
            int wordStart = shift;
            while(wordStart < s.length() - wordLen)
            {
                HashSet<String> wordsSeen = new HashSet<String>(); //could do this with a binary array for maximum efficiency
                int numWords = 0;
                String word ="";
                boolean check = false;
                boolean seen = true;
                do
                {
                    
                    check = false;
                    seen = true;
                    word = s.substring(wordStart + numWords * wordLen, wordStart + (numWords+1) * wordLen);

                    if(!wordsSeen.contains(word))
                        seen = false;
                    if(wordsSet.contains(word) && !seen)
                    {
                        check = true;
                        wordsSeen.add(word);
                        numWords++;
                    }
                    // System.out.println(word + " " + numWords);
                    if(numWords == words.length)
                    {
                        wordsSeen.remove(s.substring(wordStart, wordStart + wordLen));
                        solutions.add(wordStart);
                        numWords--;
                        wordStart += wordLen;

                    }
                } while(check && wordStart + numWords * wordLen < s.length() - wordLen);
                if(seen)
                    wordStart = wordStart + numWords * wordLen; // basically we start at the position that word appeared, 
                    //so like abcabc with word abc, now we'd be moved to position 2, note numWords would be = 1
                else if(!wordsSet.contains(word))
                    wordStart = wordStart + (numWords+1) * wordLen;// so askabc, if we first read ask, next time moved to abc
                else
                    wordStart = s.length();// we've ran out of words
            }
        }
        return solutions;
    }
    
}
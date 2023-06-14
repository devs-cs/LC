// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> remaining = new ArrayList<Integer>();
         for(int num: nums)
            remaining.add(num);
        
        recur(new ArrayList<Integer>(), remaining);
        return(combinations);
        }
    
    private List<List<Integer>> combinations = new ArrayList<List<Integer>>();
    public void recur(List<Integer> temp, List<Integer> remaining)
    {
        //System.out.println(temp);
        if(remaining.size() == 0)
        {
            List<Integer> submit = new ArrayList<Integer>();
            for(int j = 0; j < temp.size(); j++)
                submit.add(temp.get(j));
            //System.out.println(temp);
            combinations.add(submit);
        }
        else
        {
            for(int i = 0; i < remaining.size(); i++)
            {
            temp.add(remaining.remove(i));
            recur(temp, remaining);
            remaining.add(i, temp.remove(temp.size()-1)); 
            }
        }
        
    }
        
 
}
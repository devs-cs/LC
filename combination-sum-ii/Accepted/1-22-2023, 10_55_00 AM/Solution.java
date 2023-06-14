// https://leetcode.com/problems/combination-sum-ii

class Solution {
    private ArrayList<List<Integer>> solutions = new ArrayList();
    private int[] cand;
    private int goal;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        cand = candidates;
        Arrays.sort(cand);
        goal = target;
        recur(new LinkedList<Integer>(), 0, 0, false, -1);
        return solutions;
    }

    private void recur(LinkedList<Integer> list, int sum, int index, boolean acceptLast, int last)
    {
        // System.out.println(index + " " + list);
        if(sum > goal)
            return;
        if(index == cand.length && sum == goal)
        {
            LinkedList<Integer> newList = new LinkedList();
            for(int i: list)
                newList.add(i);
            solutions.add(newList);
            return;
        }
        else if (index == cand.length)
            return;
        

        if(cand[index] == last && acceptLast)
        {
            list.add(cand[index]);
            recur(list, sum + cand[index], index+1, true, cand[index]);
            list.removeLast();
        }
        else
        {
            list.add(cand[index]);
            recur(list, sum + cand[index], index+1, true, cand[index]);
            list.removeLast();
            recur(list, sum, index+1, false, cand[index]);
        }
    }
}
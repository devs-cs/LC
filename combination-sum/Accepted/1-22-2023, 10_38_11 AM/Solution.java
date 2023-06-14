// https://leetcode.com/problems/combination-sum

class Solution {

    private ArrayList<List<Integer>> solutions = new ArrayList();
    private int[] cand;
    private int goal;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        // cand = new int[candidates.length];
        // for(int i =0; i < candidates.length; i++)
        //     cand[i] = candidates[candidates.length - 1 - i];
        cand = candidates;
        goal = target;
        
        recur(new LinkedList(), 0, 0);
        // System.out.println(solutions.getFirst());
        return solutions;
    }

    // every solution has a unique ordering from low to high, 

    private void recur(LinkedList<Integer> list, int sum, int indexLast)
    {
        if(sum > goal)
            return;
        if(sum == goal)
        {
            LinkedList<Integer> newList = new LinkedList();
            for(int i: list)
                newList.add(i);
            solutions.add(newList);
            return;
        }
        for(int i = indexLast; i < cand.length && sum + cand[i] <= goal; i++)
        {
            list.add(cand[i]);
            recur(list, sum + cand[i], i);
            list.removeLast();
        }
    }
}
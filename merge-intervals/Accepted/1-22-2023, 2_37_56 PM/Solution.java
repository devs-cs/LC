// https://leetcode.com/problems/merge-intervals

class Solution {

    class Pair
    {
        public int a, b ;
        public Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
        public String toString()
        {
           return("(" + a + ", " + b + ")");
        }
    }
    public int[][] merge(int[][] intervals) {
        ArrayList<Pair> events = new ArrayList<Pair>();
        ArrayList<Pair> solutions = new ArrayList<Pair>();
        for(int i = 0; i < intervals.length; i++)
        {
            events.add(new Pair(intervals[i][0], 1));
            events.add(new Pair(intervals[i][1], -1));
        }
        events.sort((p1, p2) -> (p1.a - p2.a != 0) ? p1.a - p2.a : p2.b - p1.b);
        int start = -1;
        int sum = 0;
        for(int i = 0; i < events.size(); i++)
        {
            Pair event = events.get(i);
            if (start == -1)
                start = event.a;
            sum+=event.b;
            if(sum == 0)
            {
                solutions.add(new Pair(start, event.a));
                start = -1;
            }
        }
        int[][] sol = new int[solutions.size()][2];
        for(int i = 0; i < sol.length; i++)
        {
            sol[i][0] = solutions.get(i).a;
            sol[i][1] = solutions.get(i).b;
        }
        return sol;
    }
}
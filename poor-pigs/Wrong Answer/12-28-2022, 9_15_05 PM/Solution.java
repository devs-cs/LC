// https://leetcode.com/problems/poor-pigs

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int trials = minutesToTest/minutesToTest;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 1000; i++) //num pigs
        {
            int pigs = i;
            int val = 1;
            for(int t = 0; t < trials-1; t++)
            {
                if(pigs > 0)
                    val *= (pigs);
                pigs--;
            }
            val = (int) Math.round(Math.pow(2, pigs) * val);
            System.out.println(i + "pigs, search " + val);
            if(val >= buckets)
                return i;
        }
        return (-1);

    }
}
        //optimal strat is to use pigs and bin search
        //each trial we can use n pigs to divide by n
        //if we need to find 1 in k, it takes log(k)

        //each division takes n

        // if buckets = 10, and trials = 2, 
        /*
        t1: 3 pigs used
        2 remaining
        max: 4 to search, requires 2. 

        so final amount of pigs used is p can search a total of 
        prod(2^p * (p*1) + (p*2)) searched with p+2 total pigs. 

        Ok so for a number k buckets. with t trials, 

        we binary search on values that might work (or just brute force for now),

    works if TP * (TP-1) * ... (TP-trials + 1) * 2^(TP-trials)





        */
        // 1 2 3 4 5 6 7 8 
        // 1 2 3 4
        // 1 3 5 7
        // 1 2 5 6 
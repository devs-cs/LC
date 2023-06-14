// https://leetcode.com/problems/booking-concert-tickets-in-groups

class BookMyShow {
    //private boolean matrix[][];
    private int seatsLeft[];
    private int n;
    private int m;
    public BookMyShow(int n, int m) {
       // matrix = new int[n][m];
        seatsLeft = new int[n];
        for(int i = 0; i < n; i++)
            seatsLeft[i] = m;
        this.n = n;
        this.m = m;
    }
    
    public int[] gather(int k, int maxRow) {
        for(int i = 0; i <= maxRow; i++)
        {
            if (seatsLeft[i] >= k)
            {
                seatsLeft[i] -=k;
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = m - seatsLeft[i]-k;
                return(arr);
            }
    
        }
        return(new int[0]);
    }
    public boolean scatter(int k, int maxRow) {
        int sum = 0;
        for(int i = 0; i <= maxRow && sum < k; i++)
            sum+= seatsLeft[i];
        if (sum < k)
            return false;
        for(int i = 0; i <= maxRow && k > 0; i++)
        {
            int remove = Math.min(k, seatsLeft[i]);
            k -= remove;
            seatsLeft[i] -=remove;
        }
        return true;
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
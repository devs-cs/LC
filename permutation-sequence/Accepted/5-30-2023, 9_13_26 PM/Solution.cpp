// https://leetcode.com/problems/permutation-sequence

class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> rem(n, 0);
        for(int i = 0; i < n; i++)
            rem[i] = i+1;
        return perm(n, k, rem);
        
    }

    string perm(int n, int k, vector<int> rem)
    {
        if(n == 1 && k == 1)
        {
            return to_string(rem[0]);
        }
        int firstInd = (k-1)/fac(n-1) ;// fac(n)/n (so amount of perms with each leading digit)
        string val = to_string(rem[firstInd]);
        rem.erase(rem.begin() + firstInd);
        return val + perm(n-1, (k-1) % fac(n-1) + 1, rem);

    }

    int fac(int n)
    {
        if(n == 1 || n== 0)
            return 1;
        return n * fac(n-1);
    }
};
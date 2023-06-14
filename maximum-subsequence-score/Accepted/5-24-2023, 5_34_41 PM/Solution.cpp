// https://leetcode.com/problems/maximum-subsequence-score

class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        vector<tuple<int, int, int>> allData (n, {0,0,0});
        for(int i  = 0; i < n; i++)
        {
            int a = nums1[i];
            int b =  nums2[i];
            allData[i] = {b, a, i};
        }

        sort(allData.begin(), allData.end());
        
        long long max = -1;
        int curNum2;
        
        priority_queue<int, vector<int>, greater<int>> pq;
        long long sum = 0;
        int capacity = 0;
        int count = 0;
        for(int i = n-1; i > n-k-1; i--)
        {
            pq.push(get<1>(allData[i]));
            sum += get<1>(allData[i]);
        }

        max = sum * get<0>(allData[n-k]);        
        for(int i = n-k-1; i >= 0; i--)
        {
            tuple<int, int, int> cur = allData[i];
            curNum2 = get<0>(cur);
            if (get<1>(cur) > pq.top())
            {
                sum -= pq.top(); 
                pq.pop();
                pq.push(get<1>(cur));
                sum += get<1>(cur);
            }
            if(i == 0 || get<0>(allData[i-1]) != curNum2)
            {
                //now we check
                if(sum * curNum2 > max)
                    max = sum * curNum2;
            }
        }
        
        return max;
        //create tuples with cur k, min multi, best sum
    }
};
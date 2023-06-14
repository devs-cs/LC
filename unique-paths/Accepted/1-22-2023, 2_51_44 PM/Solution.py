// https://leetcode.com/problems/unique-paths

class Solution(object):
    def fact(self,a):
        if a <= 1:
            return 1
        return a * self.fact(a-1)
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        return self.fact(m+n-2)/(self.fact(n-1)* self.fact(m-1)) # n C k = n!/(k! * (n-k)!)
        # return 0



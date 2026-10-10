class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # At each step, take or don't take
        # Take = 1 + biggestLengthOfRest(n[i], i)
        # Not Take = continue
        self.seen = dict()
        self.nums = nums
        return self.helper(0, -1001)
    def helper(self, i, lim):
        if (i == len(self.nums)):
            return 0
        if (i, lim) in self.seen:
            return self.seen[(i, lim)]
        
        ans = 0
        if (self.nums[i] <= lim):
            ans = self.helper(i+1, lim)
        else:
            ans = max(self.helper(i+1, lim), 1+self.helper(i+1,self.nums[i]))
        self.seen[(i, lim)] = ans
        return ans

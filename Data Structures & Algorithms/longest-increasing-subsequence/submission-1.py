class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # At each step, take or don't take
        # Take = 1 + biggestLengthOfRest(n[i], i)
        # Not Take = continue
        seen = dict()
        def helper( i, lim):
            if (i == len(nums)):
                return 0
            if (i, lim) in seen:
                return seen[(i, lim)]
            
            ans = 0
            if (nums[i] <= lim):
                ans = helper(i+1, lim)
            else:
                ans = max(helper(i+1, lim), 1+helper(i+1,nums[i]))
            seen[(i, lim)] = ans
            return ans
        return helper(0, -1001)


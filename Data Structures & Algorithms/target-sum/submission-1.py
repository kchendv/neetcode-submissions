class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # (index, target)
        seen = dict()
        N = len(nums)
        def helper(i, t):
            if (i == N):
                return 1 if t == 0 else 0
            if (i, t) in seen:
                return seen[(i, t)]
            ans = helper(i+1, t-nums[i]) + helper(i+1, t+nums[i])
            seen[(i,t)] = ans
            return ans
        return helper(0, target)
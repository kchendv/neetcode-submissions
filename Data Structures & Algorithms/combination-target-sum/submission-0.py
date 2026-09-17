class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        self.memo = dict()
        self.nums = nums
        return self.helper(target, 0)

    def helper(self, target, ind):
        if (target, ind) in self.memo:
            return self.memo[(target, ind)]
        ans = []
        tnum = self.nums[ind]
        if ind == len(self.nums) - 1:
            if (target % tnum == 0):
                ans = [[tnum] * (target // tnum)]
            else:
                ans = []
        else:
            for i in range((target // tnum) + 1):
                prefix = [tnum] * i
                suffix = self.helper(target - (tnum * i), ind + 1)
                for s in suffix:
                    ans.append(prefix + s)
        

        self.memo[(target,ind)] = ans
        return ans
        


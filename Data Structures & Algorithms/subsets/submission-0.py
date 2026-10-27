class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        cur = [[]]
        for n in nums:
            cur = cur[:] + [c+[n] for c in cur]
        return cur
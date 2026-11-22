class Solution:
    def jump(self, nums: List[int]) -> int:
        # Work backwards
        N = len(nums)
        if N == 1:
            return 0
        anss = [1000000] * N
        i = N - 1
        while i >= 0:
            if i + nums[i] >= (N-1):
                anss[i] = 1
            else:
                anss[i] = 1 + min([anss[j] for j in range(i, min(i+nums[i]+1, N))])
            i -= 1
        # print(anss)
        return anss[0]
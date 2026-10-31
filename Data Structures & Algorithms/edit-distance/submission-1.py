class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # the min is the difference between the lengths
        # the max is the length of the longer word

        M, N = len(word1), len(word2)
        
        seen = dict()
        def helper(c1, c2):
            if c1 == M and c2 == N:
                return 0
            if (c1, c2) in seen:
                return seen[(c1,c2)]
            if c1 == M:
                ans = 1 + helper(c1, c2+1)
            elif c2 == N:
                ans = 1 + helper(c1+1, c2)
            else: 
                ans = 1 + min(helper(c1+1, c2), helper(c1, c2+1))
                ans = min(ans, (1 if word1[c1] != word2[c2] else 0) + helper(c1+1, c2+1))
            seen[(c1,c2)] = ans
            return ans
        return helper(0,0)
class Solution:
    def countSubstrings(self, s: str) -> int:
        
        # choose starting point
        # add one score
        # try to expand
        ans = 0
        N = len(s)
        for i in range(N):
            l = i
            r = i
            ans += 1
            while l > 0 and r < (N - 1) and s[l-1] == s[r+1]:
                # print(l,r)
                ans += 1
                l -= 1
                r += 1
        for i in range(N - 1):
            l = i
            r = i + 1
            if s[l] == s[r]:
                # print(l,r)
                ans += 1
                while l > 0 and r < (N - 1) and s[l-1] == s[r+1]:
                    # print(l,r)
                    ans += 1
                    l -= 1
                    r += 1

        return ans
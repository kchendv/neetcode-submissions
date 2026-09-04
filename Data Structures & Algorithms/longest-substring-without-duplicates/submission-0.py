class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        ans = 0
        incl = {s[0]}
        curl = 0
        curr = 0
        while (curr < len(s) -1):
            if (s[curr + 1] in incl):
                ans = max(ans, curr - curl + 1)
                while (s[curl] != s[curr+1]):
                    incl.remove(s[curl])
                    curl += 1
                incl.remove(s[curl])
                curl += 1
            incl.add(s[curr + 1])
            curr += 1
        ans = max(ans, curr - curl + 1)
        return ans

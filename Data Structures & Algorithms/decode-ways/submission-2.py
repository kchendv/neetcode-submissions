class Solution:
    def numDecodings(self, s: str) -> int:
        pp = (1 if self.isSValid(s[-1]) else 0)
        if len(s) == 1:
            return pp
        p = (1 if self.isDValid(s[-2], s[-1]) else 0) + (pp if self.isSValid(s[-2]) else 0)
        for i in range(len(s) - 2):
            temp = p
            p = (pp if self.isDValid(s[-3 - i], s[-2 - i]) else 0) + (p if self.isSValid(s[-3 - i]) else 0)
            pp = temp
        return p
        # ways[i] = (if can consume one, ways of s[i+1]) + (if can consume two, ways of s[i+2])

    def isDValid(self, a, b):
        if a == '1':
            return True
        if a == '2' and (b in ['0','1','2','3','4','5','6']):
            return True
        return False
    def isSValid(self, a):
        return a != '0'
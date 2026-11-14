class Node:
    def __init__(self, v):
        self.v = v
        self.parent = None
    def p(self):
        cur = self
        while cur.parent != None:
            cur = cur.parent
        return cur
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        N = len(edges)
        memo = [Node(v) for v in range(N)]
        for e in edges:
            e0p = memo[e[0] - 1].p()
            e1p = memo[e[1] - 1].p()
            if e0p == e1p:
                return e
            e0p.parent = e1p
        return []
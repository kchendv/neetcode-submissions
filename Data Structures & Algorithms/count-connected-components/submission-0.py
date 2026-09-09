class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        class Node:
            def __init__(self, val):
                self.val = val
                self.parent = None
            def getRoot(self):
                cur = self
                while cur.parent != None:
                    cur = cur.parent
                return cur
        
        nodes = [Node(v) for v in range(n)]

        for e in edges:
            p0 = nodes[e[0]].getRoot()
            p1 = nodes[e[1]].getRoot()
            if p0 != p1:
                p0.parent = p1
        count = 0
        for node in nodes:
            if node.getRoot() == node:
                count += 1
        return count

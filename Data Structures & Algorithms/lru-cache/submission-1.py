class Node:
    def __init__(self, k, v):
        self.k = k
        self.v = v
        self.p = None
        self.n = None
class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.l = Node(0,0)
        self.r = Node(0,0)
        self.l.n = self.r
        self.r.p = self.l
        self.memo = dict()

    def get(self, key: int) -> int:
        if key in self.memo:
            N = self.memo[key]
            p = N.p
            n = N.n
            p.n = n
            n.p = p

            p = self.r.p
            p.n = N
            N.p = p
            N.n = self.r
            self.r.p = N
            return N.v
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.memo:
            N = self.memo[key]
            N.v = value
            p = N.p
            n = N.n
            p.n = n
            n.p = p

            p = self.r.p
            p.n = N
            N.p = p
            N.n = self.r
            self.r.p = N
        else:
            if len(self.memo) >= self.cap:
                TR = self.l.n
                self.l.n = TR.n
                TR.n.p = self.l
                del self.memo[TR.k]
            N = Node(key, value)
            self.memo[key] = N
            p = self.r.p
            p.n = N
            N.p = p
            self.r.p = N
            N.n = self.r
            
        

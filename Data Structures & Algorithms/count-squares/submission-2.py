class CountSquares:

    def __init__(self):
        self.memo = dict()
        

    def add(self, point: List[int]) -> None:
        p = tuple(point)
        if p in self.memo:
            self.memo[p] += 1
        else:
            self.memo[p] = 1

    def count(self, point: List[int]) -> int:
        x = tuple(point)
        ans = 0
        # consider every point as the diagonal
        for p, v in self.memo.items():
            if p[0] != x[0] and p[1] != x[1]:
                ans += (v * self.memo.get((p[0], x[1]), 0) * self.memo.get((x[0], p[1]), 0))
        return ans

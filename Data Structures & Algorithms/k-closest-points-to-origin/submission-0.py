class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        pp = []
        for point in points:
            d = (point[0] * point[0]) + (point[1] * point[1])
            pp.append((d, point))
        pp.sort()
        return [p for (d, p) in pp[:k]]
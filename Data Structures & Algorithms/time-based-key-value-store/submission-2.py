class TimeMap:

    def __init__(self):
        self.memo = dict()

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.memo:
            self.memo[key].append((timestamp, value))
        else:
            self.memo[key] = [(timestamp, value)]

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.memo:
            return ""
        p = self.memo[key]
        l = 0
        r = len(p) - 1
        while l <= r:
            mid = (l+r)//2
            if p[mid][0] == timestamp:
                return p[mid][1]
            elif p[mid][0] > timestamp:
                r = mid - 1
            else:
                l = mid + 1
        if r < 0:
            return ""
        return p[r][1]

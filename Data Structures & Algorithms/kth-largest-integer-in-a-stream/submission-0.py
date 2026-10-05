class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.q = deque()
        self.k = k
        for n in nums:
            self.add(n)

    def add(self, val: int) -> int:
        ind = 0
        while ind < len(self.q) and val > self.q[ind]:
            ind += 1
        self.q.insert(ind, val)

        if len(self.q) > self.k:
            self.q.popleft()
        return self.q[0]
        

        


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # states (day, have)
        # f(N-1, True) = prices[N-1]
        # f(N-1, False) = 0
        # f(a, True) = max(f(a+1, True), f(a+2, False) + prices[a])
        # f(a, False) = max(f(a+1, False), f(a+1, True) - prices[a])
        N = len(prices)
        ans = [[0, 0] for _ in range(N)]
        
        ans[0][0] = 0 # day n-1, have coin = false
        ans[0][1] = prices[N-1]

        for i in range(1, N):
            ans[i][0] = max(ans[i-1][0], ans[i-1][1] - prices[N-1-i])
            ans[i][1] = max(ans[i-1][1], (ans[i-2][0] if i >1 else 0) + prices[N-1-i])
        # print(ans)
        return ans[-1][0]

class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # The height is the min between the current two heights
        # The width is the distance apart
        # If choosing an alternative pillar, it should be either further or taller
        # Anything closer AND shorter is a skip

        l = 0
        r = len(heights) - 1
        dfs = [(l, r)]
        ans = 0
        while dfs:
            #print(dfs)
            ll, rr= dfs.pop()
            ans =  max(ans,(rr-ll) * (min(heights[ll], heights[rr])))
            nbl = 0
            for i in range(ll + 1, rr):
                if heights[i] > heights[ll]:
                    nbl = i
                    break
            if nbl != 0:
                dfs.append((nbl, rr))
            
            nbr = 0
            for j in range(rr-1, ll, -1):
                if heights[j] > heights[rr]:
                    nbr = j
                    break
            if nbr != 0:
                dfs.append((ll, nbr))
        return ans
            
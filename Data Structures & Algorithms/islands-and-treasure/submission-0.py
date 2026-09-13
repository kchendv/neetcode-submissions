class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        # multi-point BFS from every treasure chest

        poi = []
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    poi.append((0,i,j))
        INF = 2147483647 
        while poi:
            dt, it, jt = poi.pop(0)
            if it > 0 and grid[it-1][jt] == INF:
                grid[it-1][jt] = dt+1
                poi.append((dt+1, it-1, jt))
            if it < len(grid) - 1 and grid[it+1][jt] == INF:
                grid[it+1][jt] = dt+1
                poi.append((dt+1, it+1, jt))
            if jt > 0 and grid[it][jt - 1] == INF:
                grid[it][jt - 1] = dt+1
                poi.append((dt+1, it, jt - 1))
            if jt < len(grid[0]) - 1 and grid[it][jt + 1] == INF:
                grid[it][jt + 1] = dt+1
                poi.append((dt+1, it, jt + 1))
            
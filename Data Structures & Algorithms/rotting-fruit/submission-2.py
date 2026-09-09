class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        to_check = []
        time = 0
        has = False
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 2:
                    to_check.append((row,col))
                elif grid[row][col] == 1:
                    has = True
        if not has:
            return 0

        while to_check:
            time += 1
            to_check_2 = to_check
            to_check = []
            while to_check_2:
                ptx, pty = to_check_2.pop()
                if (ptx > 0 and grid[ptx - 1][pty] == 1):
                    grid[ptx - 1][pty] = 2
                    to_check.append((ptx - 1, pty))
                if (ptx < len(grid) - 1 and grid[ptx + 1][pty] == 1):
                    grid[ptx + 1][pty] = 2
                    to_check.append((ptx + 1, pty))
                if (pty > 0 and grid[ptx][pty - 1] == 1):
                    grid[ptx][pty - 1] = 2
                    to_check.append((ptx, pty - 1))
                if (pty < len(grid[0]) - 1 and grid[ptx][pty +1] == 1):
                    grid[ptx][pty + 1] = 2
                    to_check.append((ptx, pty + 1))
            

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    return -1
        return time - 1
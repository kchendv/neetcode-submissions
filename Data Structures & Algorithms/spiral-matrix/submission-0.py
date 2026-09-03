class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        output = []
        curx = 0
        cury = 0
        mode = 0
        rlim = len(matrix[0]) -1
        llim = 0
        tlim = 0
        blim = len(matrix)-1
        while rlim >= llim and blim >= tlim:
            output.append(matrix[cury][curx])
            if mode == 0:
                if curx == rlim:
                    mode = 1
                    cury += 1
                    tlim += 1
                else:
                    curx += 1
            elif mode == 1:
                if cury == blim:
                    mode = 2
                    curx -= 1
                    rlim -= 1
                else:
                    cury += 1
            elif mode == 2:
                if curx == llim:
                    mode = 3
                    cury -= 1
                    blim -= 1
                else:
                    curx -= 1
            else:
                if cury == tlim:
                    mode = 0
                    curx += 1
                    llim += 1
                else:
                    cury -= 1
        return output
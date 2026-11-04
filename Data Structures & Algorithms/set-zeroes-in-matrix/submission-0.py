class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rows = set()
        cols = set()
        M, N = len(matrix), len(matrix[0])
        for row in range(M):
            for col in range(N):
                if matrix[row][col] == 0:
                    rows.add(row)
                    cols.add(col)
        
        for row in range(M):
            for col in range(N):
                if row in rows or col in cols:
                    matrix[row][col] = 0
        
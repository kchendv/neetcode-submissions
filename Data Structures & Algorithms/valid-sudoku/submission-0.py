class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Check the next open piece
        # If no open piece, return True
        # Check valid candidates 

        for i in range(9):
            seenr = set()
            seenc = set()
            for j in range(9):
                if board[i][j] != '.':
                    if board[i][j] in seenr:
                        return False
                    seenr.add(board[i][j])
                if board[j][i] != '.':
                    if board[j][i] in seenc:
                        return False
                    seenc.add(board[j][i])
        for i in range(3):
            for j in range(3):
                seenc = set()
                for ip in range(3):
                    for jp in range(3):
                        if board[i*3+ip][j*3+jp] != '.':
                            if board[i*3+ip][j*3+jp] in seenc:
                                return False
                        seenc.add(board[i*3+ip][j*3+jp])
        return True
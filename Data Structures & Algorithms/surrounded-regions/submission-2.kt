class Solution {
    private lateinit var board: Array<CharArray>;
    fun solve(board: Array<CharArray>) {
        this.board = board;
        for (i in 0..board.size - 1) {
            dfs(i, 0)
            dfs(i, board[0].size - 1)
        }
        for (j in 0..board[0].size - 1) {
            dfs(0, j)
            dfs(board.size - 1, j)
        }
        for (i in 0..board.size - 1) {
            for (j in 0..board[0].size-1) {
                if (board[i][j] == 'Q') {
                    board[i][j] = 'O'
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
            }
        }
    }
    private fun dfs(x: Int, y: Int) {
        if (x >= 0 && x < board.size && y >= 0 && y < board[0].size && board[x][y] == 'O') {
            board[x][y] = 'Q'
            dfs(x+1, y)
            dfs(x-1,y)
            dfs(x,y+1)
            dfs(x,y-1)
        }
    }
}

class Solution {
    class Coord {
        int x;
        int y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        int M = board.length;
        int N = board[0].length;
        LinkedList<Coord> dfs = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O') {
                dfs.add(new Coord(i, 0));
            }
            if (board[i][N-1] == 'O') {
                dfs.add(new Coord(i, N-1));
            }
        }
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O') {
                dfs.add(new Coord(0, j));
            }
            if (board[M-1][j] == 'O') {
                dfs.add(new Coord(M-1, j));
            }
        }
        while (!dfs.isEmpty()) {
            Coord c = dfs.pop();
            board[c.x][c.y] = 'Q';
            if (c.x >= 1 && board[c.x - 1][c.y] == 'O') {
                dfs.add(new Coord(c.x-1, c.y));
            }
            if (c.x < M - 1 && board[c.x+1][c.y] == 'O') {
                dfs.add(new Coord(c.x+1, c.y));
            }
            if (c.y >= 1 && board[c.x][c.y - 1] == 'O') {
                dfs.add(new Coord(c.x, c.y-1));
            }
            if (c.y < N -1 && board[c.x][c.y + 1] == 'O') {
                dfs.add(new Coord(c.x, c.y+1));
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'Q') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}

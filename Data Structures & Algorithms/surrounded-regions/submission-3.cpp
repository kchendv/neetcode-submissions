class Solution {
public:
    void solve(vector<vector<char>>& board) {
        this->board = &board;
        for (int i = 0; i < board.size(); i++) {
            dfs(i, 0);
            dfs(i, board[0].size() - 1);
        }
        for (int j = 0; j < board[0].size(); j++) {
            dfs(0, j);
            dfs(board.size()-1, j);
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size();j++) {
                if (board[i][j] == 'Q') {
                    board[i][j] = 'O'; 
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    };
private:
    vector<vector<char>>* board;
    void dfs(int x, int y) {
        if (x >= 0 && x < (*board).size()&& y >= 0 && y < (*board)[0].size() && (*board)[x][y] == 'O') {
            (*board)[x][y] = 'Q';
            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y+1);
            dfs(x, y-1);
        }
    };
};

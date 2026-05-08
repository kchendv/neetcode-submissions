class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        gridi = grid;
        m = grid.size();
        n = grid[0].size();
        int count = 0;
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (gridi[i][j] == '1') {
                    count++;
                    submerge(i, j);
                }
            }
        }
        return count;
    }
private:
    int m;
    int n;
    vector<vector<char>> gridi;
    void submerge(int i, int j) {
        if (i >= 0 &&
            i < m &&
            j >= 0 &&
            j < n &&
            gridi[i][j] == '1'
        ) {
            gridi[i][j] = '0';
            submerge(i+1,j);
            submerge(i-1,j);
            submerge(i,j+1);
            submerge(i,j-1);
        }
    }
};

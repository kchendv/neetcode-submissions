class Solution {
    public char[][] gridi;
    public int numIslands(char[][] grid) {
        gridi = grid;
        int count = 0;
        for (int i = 0; i < gridi.length; i++) {
            for (int j = 0; j < gridi[i].length; j++) {
                if (gridi[i][j] == '1') {
                    count ++;
                    submerge(i, j);
                }
            }
        }
        return count;
    }
    public void submerge(int i, int j) {
        if (i < 0 || i >= gridi.length || j < 0 || j >= gridi[0].length) {
            return;
        }
        if (gridi[i][j] == '0') {
            return;
        }
        gridi[i][j] = '0';
        submerge(i+1, j);
        submerge(i-1, j);
        submerge(i, j+1);
        submerge(i, j-1);

    }
}

class Solution {
    private lateinit var gridi: Array<CharArray>
    fun numIslands(grid: Array<CharArray>): Int {
        gridi = grid
        var count = 0
        for ((i, row) in gridi.withIndex()) {
            for ((j, item) in row.withIndex()) {
                if (item == '1') {
                    count++
                    submerge(i, j)
                }
            }
        }
        return count
    }
    private fun submerge(i: Int, j: Int) {
        if (i < 0 || i >= gridi.size || j < 0 || j >= gridi[0].size) {
            return
        }
        if (gridi[i][j] == '0') {
            return
        }
        gridi[i][j] = '0'
        submerge(i-1,j)
        submerge(i+1,j)
        submerge(i,j-1)
        submerge(i,j+1)
    }
}

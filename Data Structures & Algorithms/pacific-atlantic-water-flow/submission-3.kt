class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val M = heights.size
        val N = heights[0].size
        val at: MutableList<MutableList<Boolean>> = MutableList(M) { MutableList(N) {false}}
        val pt: MutableList<MutableList<Boolean>> =  MutableList(M) { MutableList(N) {false}}
        val ans: MutableList<List<Int>> = mutableListOf()
        val aq: MutableList<MutableList<Int>> = mutableListOf()
        val pq: MutableList<MutableList<Int>> = mutableListOf()
        for (i in 0..M-1) {
            pq.add(mutableListOf(i,0))
            aq.add(mutableListOf(i, N-1))
        }
        for (j in 0..N-1) {
            pq.add(mutableListOf(0,j))
            aq.add(mutableListOf(M-1, j))
        }
        while (pq.isNotEmpty()) {
            val pp = pq.removeLast()
            if (pt[pp[0]][pp[1]] == false) {
                pt[pp[0]][pp[1]] = true
                val h = heights[pp[0]][pp[1]]
                if (pp[0] > 0 && heights[pp[0] - 1][pp[1]] >= h) {
                    pq.add(mutableListOf(pp[0]- 1, pp[1]))
                }
                if (pp[0] < (M-1) && heights[pp[0] + 1][pp[1]] >= h) {
                    pq.add(mutableListOf(pp[0] + 1, pp[1]))
                }
                if (pp[1] > 0 && heights[pp[0]][pp[1]-1] >= h) {
                    pq.add(mutableListOf(pp[0], pp[1]-1))
                }
                if (pp[1] < (N-1) && heights[pp[0]][pp[1]+1] >= h) {
                    pq.add(mutableListOf(pp[0], pp[1]+1))
                }
            }
        }
        
        while (aq.isNotEmpty()) {
            val aa = aq.removeLast()
            if (at[aa[0]][aa[1]] == false) {
                at[aa[0]][aa[1]] = true
                val h = heights[aa[0]][aa[1]]
                if (aa[0] > 0 && heights[aa[0] - 1][aa[1]] >= h) {
                    aq.add(mutableListOf(aa[0]- 1, aa[1]))
                }
                if (aa[0] < (M-1) && heights[aa[0] + 1][aa[1]] >= h) {
                    aq.add(mutableListOf(aa[0] + 1, aa[1]))
                }
                if (aa[1] > 0 && heights[aa[0]][aa[1]-1] >= h) {
                    aq.add(mutableListOf(aa[0], aa[1]-1))
                }
                if (aa[1] < (N-1) && heights[aa[0]][aa[1]+1] >= h) {
                    aq.add(mutableListOf(aa[0], aa[1]+1))
                }
            }
        }
        for (i in 0..M-1) {
            for (j in 0..N-1) {
                if (pt[i][j] && at[i][j]) {
                    ans.add(listOf(i,j))
                }
            }
        }
        return ans
    }
}

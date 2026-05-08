class Solution {
    fun maxProfit(prices: IntArray): Int {
        // choose a point, to the right of it choose the highest
        // move backwards, if the point is lower, choose it
        // OR if it was higher, go to it as the sell point

        // for each point, determine what is the highest to the right of it
        // get the max of highest to the right - it
        val l = prices.size
        if (l == 0) {
            return 0
        }
        val highestToTheRight: MutableList<Int> = MutableList(l) { 0 }
        var curHighest = prices[l-1]
        for (i in 1..l) {
            highestToTheRight[l-i] = curHighest
            curHighest = maxOf(curHighest, prices[l-i])
        }
        return (1..l).map { i ->
            highestToTheRight[i - 1] - prices[i - 1] 
        }.max()
    }
}

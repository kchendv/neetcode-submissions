class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        if (n <= 2) {
            return cost.min()
        }
        val costSum = MutableList(n) {0}
        costSum[n - 1] = cost[n - 1]
        costSum[n - 2] = cost[n - 2]
        for (i in n-3 downTo 0) {
            costSum[i] = cost[i] + minOf(costSum[i+1], costSum[i+2])
        } 
        println(costSum)
        return minOf(costSum[0], costSum[1])
    }
}

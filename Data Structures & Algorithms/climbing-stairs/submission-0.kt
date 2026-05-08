class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 1) {
            return 1
        }
        var lastOne = 1
        var lastTwo = 1

        for (i in 2..n) {
            val currentWays = lastOne + lastTwo
           lastTwo = lastOne
           lastOne = currentWays 
        }
        return lastOne

    }
}

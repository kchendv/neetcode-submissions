class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        // Max answer: max(piles)
        // Min answer: 1
        var left = 1
        var right = piles.max()
        while (left < right) {
            var mid: Int = (left + right) / 2
            var speed = getSpeed(piles, mid)
            if (speed > h) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
    fun getSpeed(piles: IntArray, s: Int): Int {
        val times: List<Int> = piles.map { p -> ceil(p.toDouble()/s.toDouble()).toInt()}
        return times.sum()
    }
}

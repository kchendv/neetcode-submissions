class Solution {
    fun hammingWeight(n: Int): Int {
        var x = 1
        var total = 0
        for (i in 0..31) {
            if ((n and x) != 0) {
                total++
            }
            x = x shl 1
        }
        return total

    }
}

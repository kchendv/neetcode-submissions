class Solution {
    fun hammingWeight(n: Int): Int {
        var nn = n
        var total = 0
        while (nn > 0) {
            if ((nn and 1) != 0) {
                total++
            }
            nn = nn shr 1
        }
        return total

    }
}

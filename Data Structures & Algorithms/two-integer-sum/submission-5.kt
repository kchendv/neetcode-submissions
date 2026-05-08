class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var numsSorted: List<Pair<Int, Int>> = nums.mapIndexed { i, n ->
            Pair(n, i)
        }
        numsSorted = numsSorted.sortedBy { it.first }
        var left = 0
        var right = nums.size - 1
        var x = 0
        while (true) {
            x = numsSorted[left].first + numsSorted[right].first
            if (x == target) {
                val li = numsSorted[left].second
                val ri = numsSorted[right].second
                if (ri > li) {
                    return intArrayOf(numsSorted[left].second, numsSorted[right].second)
                }
                return intArrayOf(numsSorted[right].second, numsSorted[left].second)
            } else if (x > target) {
                right--
            } else {
                left++
            }
        }
        return IntArray(1) {5};
    }
}

class Solution {
    fun search(nums: IntArray, target: Int): Int {

        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid: Int = (left + right) / 2
            val midNum = nums.get(mid)
            if (midNum == target) {
                return mid
            } else if (midNum > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }
}

class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val seenMap: HashSet<Int> = hashSetOf()
        nums.forEach { num ->
            if (seenMap.contains(num)) {
                return true
            } else {
                seenMap.add(num)
            }
        }
        return false
    }
}

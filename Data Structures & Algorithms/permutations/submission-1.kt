class Solution {
    var memo: MutableMap<IntArray, List<List<Int>>> = mutableMapOf<IntArray, List<List<Int>>>()

    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.size == 0) {
            return listOf(listOf())
        }
        if (memo.contains(nums)) {
            return memo[nums] ?: listOf(listOf())
        }
        val ans: MutableList<MutableList<Int>> = mutableListOf();
        nums.forEachIndexed { i, n ->
            val numsList = nums.toMutableList()
            numsList.removeAt(i)
            val newArray = numsList.toIntArray()
            val permuted = permute(newArray)
            permuted.forEach { p ->
                var pc: MutableList<Int> = p.toMutableList()
                pc.add(nums[i])
                ans.add(pc)
            }
        }
        memo[nums] = ans
        return ans
    }
}

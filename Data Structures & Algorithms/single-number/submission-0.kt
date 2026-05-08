class Solution {
    fun singleNumber(nums: IntArray): Int {
        // XOR everything
        return nums.fold(0) { acc, element ->
            acc xor element
        }
    }
}

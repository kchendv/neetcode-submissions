class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var x = digits.size - 1
        var carry = true
        while (carry && x >= 0) {
            if (digits[x] == 9) {
                digits[x] = 0
                carry = true
            } else {
                digits[x]++
                carry = false
            }
            x--
        }
        if (carry) {
            val new = IntArray(digits.size + 1) {0}
            new[0] = 1
            return new
        }
        return digits
    }
}

class Solution {
    fun isHappy(n: Int): Boolean {
        val seenN = mutableSetOf<Int>()
        var curN = n
        while (true) {
            if (curN == 1) {
                return true;
            }
            if (seenN.contains(curN)) {
                return false;
            }
            seenN.add(curN)
            curN = squareSumDigits(curN)
        }
        return false;
    }

    fun squareSumDigits(n: Int): Int {
        var rem = n
        var curSum = 0
        var dig = 0
        while (rem > 0) {
            dig = (rem % 10)
            curSum += dig * dig
            rem /= 10
        }
        return curSum
    }
}

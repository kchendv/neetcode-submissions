class Solution {
    fun isPalindrome(s: String): Boolean {
        val sFiltered = s
            .lowercase()
            .filter { c ->c.isLetterOrDigit() }
        println(sFiltered)
        val slength = sFiltered.length
        if (slength == 0) {
            return true
        }
        for (i in 0..((slength/2))) {
            if (sFiltered[i] != sFiltered[slength - i - 1]) {
                return false
            }
        }
        return true
    }
}

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val counts: MutableMap<Char, Int> = mutableMapOf()

        s.forEach { c ->
            counts[c] = 1 + counts.getOrDefault(c, 0)
        }
        t.forEach { c ->
            counts[c] = counts.getOrDefault(c, 0) - 1
        }
        counts.values.forEach { v ->
            if (v != 0) {
                return false
            }
        }
        return true
    }
}

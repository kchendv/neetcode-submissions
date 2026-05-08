class Solution {
    fun isValid(s: String): Boolean {
        val bstack: MutableList<Char> = mutableListOf()
        s.forEach { c ->
            if (c == '(' || c=='{' || c=='[') {
                bstack.add(c)
            } else {
                if (bstack.isEmpty()) {
                    return false
                }
                val last = bstack.removeLast()
                if (c == ')' && last != '(') {
                    return false
                }
                if (c == ']' && last != '[') {
                    return false
                }
                if (c == '}' && last != '{') {
                    return false
                }
            }
            
        }
        return bstack.isEmpty()
    }
}

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val x: MutableMap<String, MutableList<String>> = mutableMapOf();
        strs.forEach { it ->
            val s = it.toCharArray().sortedArray().joinToString("") 
            x.getOrPut(s){ mutableListOf()}.add(it)
        }
        return x.values.toList()
    }
}

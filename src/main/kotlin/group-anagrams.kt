import kotlin.text.iterator

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<Int, MutableList<String>>()

        for (s in strs) {
            val hash = stringHash(s)
            map.getOrPut(hash) { mutableListOf() }.add(s)
        }

        return map.values.toList()
    }

    private fun stringHash(str: String): Int {
        var hash = 0
        val counts = IntArray(26)
        for (c in str) counts[c - 'a']++

        for (i in 0 until 26) {
            hash = hash * 31 + counts[i]
        }
        return hash
    }
}
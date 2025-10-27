class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charIndexMap = mutableMapOf<Char, Int>()
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            val currentChar = s[right]

            if (charIndexMap.containsKey(currentChar) && charIndexMap[currentChar]!! >= left) {
                left = charIndexMap[currentChar]!! + 1
            }

            charIndexMap[currentChar] = right
            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}
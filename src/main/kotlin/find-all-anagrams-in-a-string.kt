class Solution {
    // 当p为3时候 如果窗口为4 那么就让left+1 使得窗口数量为3 然后在下一个循环比较频率是否相同
    fun findAnagrams(s: String, p: String): List<Int> {
        val pCount = IntArray(26) // p 字母频率
        val sCount = IntArray(26) // s 当前窗口字母频率
        val result = mutableListOf<Int>()
        p.forEachIndexed { index, p ->
            pCount[p - 'a']++
        }
        var left = 0
        for (right in s.indices) {
            sCount[s[right] - 'a']++

            // 如果窗口太长，移除左边字符
            if (right - left + 1 > p.length) {
                sCount[s[left] - 'a']--
                left++
            }

            // 当窗口长度刚好时，比较两个频率表
            if (right - left + 1 == p.length) {
                if (sCount.contentEquals(pCount)) {
                    result.add(left)
                }
            }
        }

        return result
    }
}
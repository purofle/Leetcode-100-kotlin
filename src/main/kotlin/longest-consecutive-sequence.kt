import kotlin.math.max

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()
        for (n in nums) set.add(n)

        var maxLen = 0
        set.forEach { n ->
            if (!set.contains(n - 1)) {
                var start = n
                // 找起点
                while (set.contains(start)) {
                    start++
                }
                maxLen = max(start - n, maxLen)
            }
        }

        return maxLen
    }
}
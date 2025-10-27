class Solution {
    // 滑动窗口的思路？
    // 实则前缀和 https://oi-wiki.org/basic/prefix-sum
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        val prefix = IntArray(nums.size + 1) { 0 }

        // until 不包括 nums.size 本身
        for (i in 1..nums.size) {
            prefix[i] = prefix[i - 1] + nums[i - 1]
        }

        var sufMap = mutableMapOf<Int, Int>()

        prefix.forEach {
            count += sufMap.getOrDefault(it - k, 0)
            sufMap[it] = sufMap.getOrDefault(it, 0) + 1
        }

        return count
    }
}
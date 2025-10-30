class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1)
        val deque = ArrayDeque<Int>()

        for (i in nums.indices) {
            while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) deque.removeLast()
            deque.addLast(i)
            if (deque.first() <= i - k) deque.removeFirst()
            if (i >= k - 1) result[i - k + 1] = nums[deque.first()]
        }

        return result
    }
}
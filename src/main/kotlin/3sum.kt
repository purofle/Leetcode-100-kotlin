// 草你妈 三数之和
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()

        if (nums.size == 3) {
            return if (nums[0] + nums[1] + nums[2] == 0) {
                listOf(nums.toList())
            } else {
                listOf()
            }
        }

        nums.sort() // 肯定先排序
        // 排序后 0 在中间 左边负数 右边正数，因此双指针
        // [-1,0,1,2,-1,-4]
        // sort: [-4,-1,-1,0,1,2]

        // 只需要遍历到倒数第三个元素
        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break

            if (i != 0 && nums[i] == nums[i - 1]) continue // 去重

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        // 跳过重复值
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--
                        left++
                        right--
                    }
                    sum < 0 -> left++
                    else -> right--
                }
            }
        }

        return result
    }
}
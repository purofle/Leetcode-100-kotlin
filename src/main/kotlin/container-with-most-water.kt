import kotlin.math.max

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {
            // 计算面积
            val area = (right - left) * minOf(height[left], height[right])
            maxArea = max(maxArea, area)

            // 移动指针
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }
}
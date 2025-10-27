import kotlin.math.max

class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        var res = 0

        while (left < right) {
            if (height[left] < height[right]) {

                leftMax = max(height[left], leftMax)

                if (height[left] < leftMax) {
                    res += leftMax - height[left]
                }

                left++

            } else {

                rightMax = max(height[right], rightMax)

                if (height[right] < rightMax) {
                    res += rightMax - height[right]
                }

                right--
            }
        }
        return res
    }
}
class Solution {
    fun trap(height: IntArray): Int {
        var result = 0

        val leftPrefix = IntArray(height.size)
        leftPrefix[0] = height[0]

        for (i in 1..leftPrefix.lastIndex) {
            leftPrefix[i] = max(leftPrefix[i - 1], height[i])
        }

        val rightSuffix = IntArray(height.size)
        rightSuffix[rightSuffix.lastIndex] = height[height.lastIndex]
        for (j in rightSuffix.lastIndex - 1 downTo 0) {
            rightSuffix[j] = max(rightSuffix[j + 1], height[j])
        }

        for (k in 1 until height.lastIndex) {
            val currentMaximumBorder = min(rightSuffix[k], leftPrefix[k])
            val currentHeight = height[k]

            val currentWater = max(0, currentMaximumBorder - currentHeight)
            result += currentWater
        }

        return result
    }
}

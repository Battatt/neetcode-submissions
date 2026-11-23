class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.lastIndex
        var maxArea = 0

        while (left < right) {
            val currMinHeight = if (heights[left] > heights[right]) heights[right] 
                                else heights[left]
            
            val currArea = currMinHeight * (right - left)
            if (currArea > maxArea) maxArea = currArea

            if (heights[left] > heights[right]) right--
            else left++
        }

        return maxArea
    }
}

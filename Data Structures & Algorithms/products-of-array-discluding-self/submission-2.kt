data class Point(
    var prefix: Int = 0,
    var suffix: Int = 0,
)

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val arr = Array<Point>(nums.size) {
            Point()
        }

        var prefix = 1
        for (i in 0 until nums.size) {
            arr[i].prefix = prefix
            prefix *= nums[i]
        }

        var suffix = 1
        for (i in nums.lastIndex downTo 0) {
            arr[i].suffix = suffix
            suffix *= nums[i]
        }

        val result = IntArray(nums.size) { 0 }
        for (i in 0 until nums.size) {
            result[i] = arr[i].prefix * arr[i].suffix
        }

        return result
    }
}

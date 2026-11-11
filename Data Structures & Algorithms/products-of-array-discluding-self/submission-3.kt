class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val arr = IntArray(nums.size) { 0 }

        var prefix = 1
        for (i in 0..nums.lastIndex) {
            arr[i] = prefix
            prefix *= nums[i]
        }

        var suffix = 1
        for (i in nums.lastIndex downTo 0) {
            arr[i] *= suffix
            suffix *= nums[i]
        }

        return arr
    }
}

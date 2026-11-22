class Solution {
    fun rotate(nums: IntArray, k: Int) {
        var steps = k


        while (steps > 0) {
            var last = nums[nums.lastIndex]

            for (i in nums.lastIndex downTo 1) {
                nums[i] = nums[i - 1]
            }

            nums[0] = last
            steps--
        }
    }
}

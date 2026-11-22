class Solution {
    fun rotate(nums: IntArray, k: Int) {
        var steps = k % nums.size


        while (steps > 0) {
            val last = nums.last()

            for (i in nums.lastIndex downTo 1) {
                nums[i] = nums[i - 1]
            }

            nums[0] = last
            steps--
        }
    }
}

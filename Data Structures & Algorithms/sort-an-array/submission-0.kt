class Solution {
    fun sortArray(nums: IntArray): IntArray {
        for (i in 0 until nums.size - 1) {
            var swapped = false
            for (j in 0 until nums.size - 1 - i) {
                if (nums[j] > nums[j + 1]) {
                    val bigger = nums[j]
                    nums[j] = nums[j + 1]
                    nums[j + 1] = bigger
                    swapped = true
                }
            }
            if (!swapped) break
        }
        return nums
    }
}

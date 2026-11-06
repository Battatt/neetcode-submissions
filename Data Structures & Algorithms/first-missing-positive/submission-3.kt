class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val positives: MutableList<Boolean> = MutableList(nums.size + 1) { 
            false
        }

        for (num in nums) {
            if (num > 0) {
                if (num < positives.size) {
                    positives[num - 1] = true
                }
            }
        }

        for (i in 0 until positives.size) {
            if (!positives[i]) {
                return i + 1
            }
        }

        return -1
    }
}

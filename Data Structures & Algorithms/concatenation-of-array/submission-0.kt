class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n * 2)
        for (i in 0 until result.size) {
            if (i >= n) {
                result[i] = nums[i - n]
            } else {
                result[i] = nums[i]
            }
        }

        return result
    }
}

class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n * 2)
        for (i in 0 until n) {
            result[i] = nums[i]
            result[i + n] = nums[i]
        }

        return result
    }
}

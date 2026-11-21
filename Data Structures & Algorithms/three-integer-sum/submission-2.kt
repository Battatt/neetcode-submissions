class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result: MutableSet<List<Int>> = mutableSetOf<List<Int>>()

        nums.sort()

        for (i in nums.indices) {
            val curr = nums[i]

            var left = i + 1
            var right = nums.lastIndex

            while (left < right) {
                val sum = nums[left] + nums[right]

                if (sum == -curr) {
                    result.add(listOf(curr, nums[left], nums[right]))
                }
                
                if (sum > -curr) {
                    right--
                } else {
                    left++
                }
            }
        }

        return result.toList()
    }
}

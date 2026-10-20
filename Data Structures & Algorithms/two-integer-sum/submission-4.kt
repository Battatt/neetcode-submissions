class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf()

        for (i in 0 until nums.size) {
            val current = nums[i]
            val needed = target - current
            if (needed in map) {
                return intArrayOf(
                    map[needed]!!,
                    i
                )
            }

            map[current] = i
        }

        return intArrayOf()
    }
}

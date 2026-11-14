class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        val map: MutableMap<Int, Int> = mutableMapOf()
        val k: Int = nums.size / 3

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val result: MutableList<Int> = mutableListOf()
        for ((key, value) in map) {
            if (value > k) result.add(key)
        }

        return result
    }
}

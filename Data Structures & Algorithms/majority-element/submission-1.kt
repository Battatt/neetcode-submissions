class Solution {
    fun majorityElement(nums: IntArray): Int {
        var map: MutableMap<Int, Int> = mutableMapOf()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        
        val maxValue = map.maxOf { it.value }

        return map.entries.find { it.value == maxValue }?.key ?: 0
        
    }
}

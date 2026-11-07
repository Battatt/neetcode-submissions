class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var map: MutableMap<Int, Int> = mutableMapOf()

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val sortedListDesc = map.entries.sortedByDescending { it.value }
        val result = IntArray(k) { 0 }
        var counter = k

        for ((num, freq) in sortedListDesc) {
            if (counter == 0) break

            result[counter - 1] = num
            counter--
        }

        return result
    }
}

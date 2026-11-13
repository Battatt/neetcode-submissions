class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var counter = 0
        for (i in 0 until nums.size) {
            var sum = nums[i]
            if (sum == k) counter++
            for (j in i + 1 until nums.size) {
                sum += nums[j]
                if (sum == k) counter++
            }
        }

        return counter
    }
}

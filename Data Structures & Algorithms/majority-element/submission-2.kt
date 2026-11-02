class Solution {
    fun majorityElement(nums: IntArray): Int {
        var res = 0
        var count = 0

        for (num in nums) {
            if (count == 0) {
                res = num
            }

            count += if (num == res) 1 else - 1
        }
        
        return res
    }
}

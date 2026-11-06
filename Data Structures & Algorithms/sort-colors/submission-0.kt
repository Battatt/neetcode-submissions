class Solution {
    fun sortColors(nums: IntArray) {
        var zeros = 0
        var ones = 0
        var twos = 0
        
        for (num in nums) {
            when (num) {
                0 -> zeros++
                1 -> ones++
                2 -> twos++
                else -> continue
            }
        }

        for (i in 0 until nums.size) {
            if (zeros > 0) {
                nums[i] = 0
                zeros--
            } else if (ones > 0) {
                nums[i] = 1
                ones--
            } else if (twos > 0) {
                nums[i] = 2
                twos--
            }
        }


    }
}

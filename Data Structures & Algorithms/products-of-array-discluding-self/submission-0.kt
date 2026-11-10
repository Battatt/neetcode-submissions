class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        val countOfZeros = nums.count { it == 0 }
        if (countOfZeros > 1) {
            return IntArray(nums.size) { 0 }
        }

        val totalProduct = nums.reduce { acc, num -> 
            if (acc == 0) {
                1 * num
            } else if (num == 0) {
                acc * 1
            } else {
                acc * num
            }
        }
        
        val result = IntArray(nums.size) { 0 }
        for (i in 0 until nums.size) {
            if (countOfZeros == 0) {
                result[i] = totalProduct / nums[i]
            } else {
                if (nums[i] == 0) {
                    result[i] = totalProduct
                }
            }
        }
        

        return result
    }
}

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex

        while (left < right) {
            val currSum = numbers[left] + numbers[right]

            if (currSum == target) {
                return intArrayOf(left + 1, right + 1)
            }

            when {
                currSum > target -> right--
                else -> left++
            }
        }

        return IntArray(2) { 0 }
    }
}

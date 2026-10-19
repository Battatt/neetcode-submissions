class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val hashSet = mutableSetOf<Int>()

        for (num in nums) {
            if (num in hashSet) {
                return true
            } else {
                hashSet.add(num)
            }
        }

        return false
    }
}

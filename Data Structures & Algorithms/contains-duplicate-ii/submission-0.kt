class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val hashSet: MutableSet<Int> = mutableSetOf()

        for (i in 0..nums.lastIndex) {
            if (i - k - 1 >= 0) {
                hashSet.remove(nums[i - k - 1])
            }

            if (nums[i] in hashSet) return true

            hashSet.add(nums[i])
        }

        return false
    }
}

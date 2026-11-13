class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val hashSet = nums.toHashSet()
        var maxLength = 0

        for (num in hashSet) {
            if (num - 1 !in hashSet) {
                var length = 1
                var delta = 1
                while (num + delta in hashSet) {
                    delta++
                    length++
                }

                if (length > maxLength) maxLength = length
            }
        }

        return maxLength
    }
}

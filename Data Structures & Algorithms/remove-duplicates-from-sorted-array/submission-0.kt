class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var lastUnique = 0
        var search = 1

        while (search < nums.size) {
            if (nums[search] != nums[lastUnique]) {
                nums[lastUnique + 1] = nums[search]
                lastUnique++
            }
            search++
        }

        return lastUnique + 1
    }
}

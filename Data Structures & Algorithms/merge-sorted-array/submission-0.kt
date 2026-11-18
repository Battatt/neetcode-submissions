class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var write = m + n - 1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[write] = nums1[i]
                nums1[i] = 0
                i--
            } else {
                nums1[write] = nums2[j]
                j--
            }
            write--
        }

        if (i < 0) {
            while (write >= 0 && j >= 0) {
                nums1[write] = nums2[j]
                write--
                j--
            }
        }
    }
}

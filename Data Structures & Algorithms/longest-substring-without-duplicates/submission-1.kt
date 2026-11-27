class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val window: MutableSet<Char> = mutableSetOf()

        var left = 0
        var maxLength = 0
        for (right in s.indices) {
            while (s[right] in window) {
                window.remove(s[left])
                left++
            }

            window.add(s[right])
            val length = right - left + 1

            if (length > maxLength) maxLength = length
        }

        return maxLength
    }
}

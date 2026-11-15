class Solution {
    fun reverseString(s: CharArray) {
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            var mem = s[left]
            s[left] = s[right]
            s[right] = mem
            left++
            right--
        }
    }
}

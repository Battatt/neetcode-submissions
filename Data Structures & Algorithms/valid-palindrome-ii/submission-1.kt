class Solution {
    fun isSubstrPalindrome(s: String, l: Int, r: Int): Boolean {
        var left = l
        var right = r

        while (left < right) {
            if (s[left] != s[right]) return false
            left++
            right--
        }
        
        return true
    }

    fun validPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            if (s[left] != s[right]) {
                return isSubstrPalindrome(s, left + 1, right) ||
                    isSubstrPalindrome(s, left, right - 1)
            }

            left++
            right--
        }

        return true
    }
}

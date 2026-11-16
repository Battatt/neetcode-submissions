class Solution {
    fun isPalindrome(s: String): Boolean {
        val filteredString = s
                                .filter {
                                    it in 'a'..'z' ||
                                    it in 'A'..'Z' ||
                                    it in '0'..'9'
                                }
                                .map { it.lowercaseChar() }
                                .joinToString("")
        var left = 0
        var right = filteredString.lastIndex

        while (left < right) {
            if (filteredString[right].lowercaseChar() != 
            filteredString[left].lowercaseChar()) return false

            right--
            left++
        }

        return true
    }
}

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val firstFrequency = IntArray(26)
        val windowFrequency = IntArray(26)

        for (char in s1) {
            firstFrequency[index(char)]++
        }

        var left = 0
        var right = s1.lastIndex

        for (i in left..right) {
            windowFrequency[index(s2[i])]++
        }

        while (right < s2.length) {
            var found = false
            for (i in firstFrequency.indices) {
                if (firstFrequency[i] != windowFrequency[i]) {
                    found = false
                    break
                }
                else found = true
            }

            if (found) return true

            windowFrequency[index(s2[left])]--
            left++

            right++
            if (right > s2.lastIndex) break
            windowFrequency[index(s2[right])]++
        }

        return false
    }

    fun index(char: Char): Int {
        return char - 'a'
    }
}

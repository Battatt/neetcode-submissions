class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var frequencies = IntArray(26)

        var left = 0
        var maxLength = 0
        for (right in 0..s.lastIndex) {
            val rightIndex = s[right] - 'A'

            frequencies[rightIndex]++

            var windowSize = right - left + 1
            var maxFreq = frequencies.maxOrNull() ?: 0
            var replacements = windowSize - maxFreq

            while (replacements > k) {
                val leftIndex = s[left] - 'A'
                left++
                frequencies[leftIndex]--

                windowSize = right - left + 1
                maxFreq = frequencies.maxOrNull() ?: 0
                replacements = windowSize - maxFreq
            } 

            if (right - left + 1 > maxLength) maxLength = right - left + 1
        }

        return maxLength
    }
}

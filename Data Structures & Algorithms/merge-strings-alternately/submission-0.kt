class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var result = ""
        var i = 0
        var j = 0
        var isCharFromWord1 = true
        
        while (i < word1.length || j < word2.length) {
            if (isCharFromWord1) {
                if (i < word1.length) {
                    result += word1[i]
                    i++
                }
                isCharFromWord1 = !isCharFromWord1
            } else {
                if (j < word2.length) {
                    result += word2[j]
                    j++
                }
                isCharFromWord1 = !isCharFromWord1
            }
        }

        return result
    }
}

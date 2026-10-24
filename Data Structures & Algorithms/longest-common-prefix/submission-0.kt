class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = strs[0]

        for (str in strs) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length - 1)

                if (prefix == "") {
                    return ""
                }
            }
        }

        return prefix
    }
}

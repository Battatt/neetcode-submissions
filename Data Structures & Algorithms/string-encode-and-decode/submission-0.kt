class Solution {

    fun encode(strs: List<String>): String {
        var result = ""
        for (str in strs) {
            result += "${str.length}#$str"
        }
        return result
    }

    fun decode(str: String): List<String> {
        val list: MutableList<String> = mutableListOf()
        var i = 0
        var j = 0
        
        while (i < str.length && j < str.length) {
            if (str[j] == '#') {
                val length = str.substring(i, j).toInt()
                val decodedStr = str.substring(j + 1, j + 1 + length)
                list.add(decodedStr)
                i = j + length + 1
                j = i
            } else {
                j++
            }
        }

        return list
    }
}

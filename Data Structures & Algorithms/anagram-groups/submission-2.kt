class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (s in strs) {
            val sortedString = s.toCharArray().sorted().joinToString("")
            if (sortedString !in map) {
                map[sortedString] = mutableListOf(s)
            } else {
                map[sortedString]!!.add(s)
            }
        }

        val result: MutableList<MutableList<String>> = mutableListOf()
        for (list in map.values) {
            result.add(list)
        }

        return result
    }
}
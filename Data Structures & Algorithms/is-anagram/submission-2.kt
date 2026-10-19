class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val hashSet: MutableSet<Char> = mutableSetOf()

        for (c in s) {
            if (c !in hashSet) {
                if (s.count { it == c } != t.count { it == c }) return false
                hashSet.add(c)
            }
        }

        return true
    }
}

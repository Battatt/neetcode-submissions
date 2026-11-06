class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val positives: MutableSet<Int> = mutableSetOf()

        for (num in nums) {
            if (num > 0) {
                positives.add(num)
            }
        }

        if (positives.isEmpty()) return 1

        val positivesList = positives.sorted().toList()

        var previous = positivesList[0]

        if (previous > 1) return 1

        for (i in 1 until positivesList.size) {
            if (positivesList[i] - previous > 1) {
                return previous + 1
            } else {
                previous = positivesList[i]
            }
        }
        
        return positivesList.last() + 1
    }
}

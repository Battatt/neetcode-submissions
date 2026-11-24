class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var left = 0
        var right = people.lastIndex
        var boatCounter = 0
        while(left <= right) {
            if (people[right] + people[left] <= limit) {
                boatCounter++
                right--
                left++
            } else {
                boatCounter++
                right--
            }
        }

        return boatCounter
        
    }
}

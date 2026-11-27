class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var leftMinimum = prices[0]

        for (i in 1..prices.lastIndex) {
            val currCost = prices[i]
            val profit = currCost - leftMinimum

            if (prices[i] < leftMinimum) leftMinimum = currCost
            if (profit > result) result = profit
        }

        return result
    }
}

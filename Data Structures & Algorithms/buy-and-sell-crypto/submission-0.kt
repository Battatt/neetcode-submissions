class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0

        for (i in 0 until prices.lastIndex) {
            for (j in i + 1..prices.lastIndex) {
                val profit = prices[j] - prices[i]

                if (profit > result) result = profit
            }
        }

        return result
    }
}

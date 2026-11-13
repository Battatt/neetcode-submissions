class Solution {
    fun maxProfit(prices: IntArray): Int {
        var totalProfit = 0

        for (i in 1 until prices.size) {
            var currentProfit = prices[i] - prices[i - 1]
            if (currentProfit > 0) {
                totalProfit += currentProfit
            }
        }

        return totalProfit
    }
}

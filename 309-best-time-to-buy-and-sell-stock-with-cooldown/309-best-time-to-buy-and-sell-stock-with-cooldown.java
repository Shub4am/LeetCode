class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int buy = -prices[0];
        int sell = 0;
        int prevSell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(prevSell - prices[i], buy);
            prevSell = sell;
            sell = Math.max(buy + prices[i], sell);
        }
        return sell;
    }
}
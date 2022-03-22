class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(sell - prices[i], buy);
            sell = Math.max(buy + prices[i] - fee, sell);
        }

        return sell;
    }
}
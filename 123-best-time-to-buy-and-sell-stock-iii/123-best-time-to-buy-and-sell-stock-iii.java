class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int buyOne = -prices[0];
        int sellOne = buyOne + prices[0];
        int buySecond = sellOne - prices[0];
        int sellSecond = buySecond + prices[0];
        
        for(int i = 1; i < prices.length; i++){
            buyOne = Math.max(buyOne, -prices[i]);
            sellOne = Math.max(sellOne, buyOne + prices[i]);
            buySecond = Math.max(buySecond, sellOne - prices[i]);
            sellSecond = Math.max(sellSecond, buySecond + prices[i]);
        }
        return Math.max(sellOne, sellSecond);
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int minCost = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minCost)
                minCost = prices[i];
            else if(prices[i] - minCost > maxProfit)
                maxProfit = prices[i] - minCost;
        }
        return maxProfit;
    }
}
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return maxProfit(prices);
        }

        int len = prices.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for (int i = 0; i < k; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < len; j++) {
                dp2[j] = Math.max(dp2[j - 1], prices[j] + tempMax);
                tempMax = Math.max(tempMax, dp1[j] - prices[j]);
            }
            dp1 = Arrays.copyOf(dp2, len);
        }

        return dp2[len - 1];
    }

    private int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }
}
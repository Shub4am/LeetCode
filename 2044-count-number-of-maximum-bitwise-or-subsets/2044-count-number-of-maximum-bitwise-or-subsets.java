class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0, dp[] = new int[1 << 17];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = max; i >= 0; --i)
                dp[i | n] += dp[i];
            max |= n;
        }
        return dp[max];
    }
}
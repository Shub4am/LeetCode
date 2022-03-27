class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int dp[][] = new int[n + 1][numCarpets + 1];
        for (int i = 1; i <= n; ++i) {
            for (int k = 0; k <= numCarpets; ++k) {
                int jump = dp[i - 1][k] + floor.charAt(i - 1) - '0';
                int cover = k > 0 ? dp[Math.max(i - carpetLen, 0)][k - 1] : 1000;
                dp[i][k] = Math.min(cover, jump);
            }
        }
        return dp[n][numCarpets];
    }
}
 
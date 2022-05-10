class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean [][][] dp = new boolean[m + 1][n + 1][103];
        dp[0][0][1] = true;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                for(int k = 1; k < 102; k++){
                    dp[i][j + 1][k] |= dp[i][j][k + (grid[i][j] == '(' ? -1 : 1)];
                    dp[i + 1][j][k] |= dp[i][j][k + (grid[i][j] == '(' ? -1 : 1)];
                }
        return dp[m][n - 1][1];
    }
}

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s = s1.length();
        int t = s2.length();
        if(s + t == s3.length()) {
            boolean[] dp = new boolean[t + 1];
            for(int i = 0; i <= s; i++) {
                for(int j = 0; j <= t; j++) {
                    if(i == 0 && j == 0)
                        dp[j] = true;
                    else if(i == 0)
                        dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt( i + j - 1);
                    else if(j == 0) 
                        dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    else 
                        dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
            return dp[t];
        }
        else 
            return false;
    }
}

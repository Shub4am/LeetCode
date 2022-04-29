class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p == null)
            return s==p;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int row=0, col=1; col<dp[0].length;col++){
            if(p.charAt(col-1) == '*')
                dp[row][col]=true;
            else
                break;
            
        }
        
        for(int row=1; row<dp.length;row++){
            for(int col=1;col<dp[0].length;col++){
                char str = s.charAt(row-1);
                char pattn = p.charAt(col-1);
                if(str == pattn || pattn == '?'){
                    dp[row][col] = dp[row-1][col-1];
                } else if(pattn == '*'){
                    dp[row][col] = dp[row][col-1] || dp[row-1][col];
                }
            }
        }
        
        return dp[s.length()][p.length()];
        
    }
}
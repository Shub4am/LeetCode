class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int [] noChange = new int[19];
        Arrays.fill(noChange, Integer.MAX_VALUE);
        for(int[] tire: tires) {
            int fi = tire[0];
            int ri = tire[1];
            int lapTime = 0;
            for(int i =1; i <= numLaps; i++) {
                int xth = fi * (int) Math.pow(ri, i - 1);
                lapTime += xth;
                if(lapTime > Math.pow(2, 17)) break;
                noChange[i] = Math.min(noChange[i], lapTime);
            }
        }
        int [] dp = new int[numLaps + 1];
        for(int i = 1; i<= numLaps; i++) {
            dp[i] = i < 19 ? noChange[i] : Integer.MAX_VALUE;
            for(int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + changeTime + dp[i - j]);
            }
        }
        return dp[numLaps];
    }
}
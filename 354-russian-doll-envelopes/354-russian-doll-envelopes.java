class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b [0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for(int[] i : envelopes){
            int height = i[1];
            int left = Arrays.binarySearch(dp, 0, res, height);
            if(left < 0)
                left = -left - 1;
            if(left == res)
                res++;
            dp[left] = height;
        }
        return res;
    }
}
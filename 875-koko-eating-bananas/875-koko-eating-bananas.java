class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles) max = Math.max(max, p);
        if(h == piles.length) return max;
        int lo = 1, hi = max, res = max ;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int time = getTime(piles, mid);
            if(time <= h) {
                res = Math.min(res, mid);
                hi = mid - 1;
            }else if(time > h) {
                lo = mid + 1;
            }
        }
        return res;
    }
    public int getTime(int []piles, int mid) {
        int sum = 0;
        for(int i = 0; i < piles.length; i++)
            sum += Math.ceil((double) piles[i] / mid);
        return sum;
    }
}
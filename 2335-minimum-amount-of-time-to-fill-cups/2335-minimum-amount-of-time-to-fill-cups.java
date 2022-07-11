class Solution {
    public int fillCups(int[] amount) {
        int res = 0, sum = 0;
        for(int i : amount) {
            res = Math.max(res, i);
            sum += i;
        }
        return Math.max(res, (sum + 1) / 2);
    }
}
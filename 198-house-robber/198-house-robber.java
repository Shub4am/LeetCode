class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int next = 0;
        for(int i : nums) {
            int temp = prev;
            prev = Math.max(next + i, prev);
            next= temp;
        }
        return prev;
    }
}
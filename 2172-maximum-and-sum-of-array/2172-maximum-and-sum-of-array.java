class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int mask = (int)Math.pow(3, numSlots) - 1;
        int[] memo = new int[mask + 1];
        return dp(nums.length - 1, mask, numSlots, memo, nums);
    }  
    private int dp(int i, int mask, int numSlots, int[] memo, int[] nums) {
        if (memo[mask] > 0) return memo[mask];
        if (i < 0) return 0;
        for (int slot = 1, bit = 1; slot <= numSlots; ++slot, bit*= 3)
            if (mask / bit % 3 > 0)
                memo[mask] = Math.max(memo[mask], (nums[i] & slot) + dp(i - 1, mask - bit, numSlots, memo, nums));
        return memo[mask];
    }
}


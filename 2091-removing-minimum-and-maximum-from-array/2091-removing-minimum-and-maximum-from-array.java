class Solution {
    public int minimumDeletions(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        for (int k = 0; k < n; ++k) {
            if (nums[i] < nums[k]) i = k;
            if (nums[j] > nums[k]) j = k;
        }
        return Math.min(Math.min(Math.max(i + 1, j + 1), Math.max(n - i, n - j)), Math.min(i + 1 + n - j, j + 1 + n - i));
    }
}
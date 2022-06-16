class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, min = nums[0], max = nums[0];
        for (int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            if (max - min > k) {
                res++;
                min = max = i;
            }
        }
        return res;
    }
}
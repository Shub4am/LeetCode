class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int i = (nums.length - k);
        return nums[i];
    }
}
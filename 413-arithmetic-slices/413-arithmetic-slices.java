class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0, len = 0;
        for(int left = 1, right = left; left < n; left = right){
            for(right = left +1; right < n && nums[right]-nums[right -1] == nums[left] - nums[left -1]; right++);
            len= right - left + 1;
            ans += (len - 1) *(len - 2)/ 2;
        }
        return ans;
    }
}
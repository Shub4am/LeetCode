class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int pos = 0;
        for(int i : nums) if(i != 0) nums[pos++] = i;
        while(pos < nums.length) nums[pos++] = 0;
    }
}
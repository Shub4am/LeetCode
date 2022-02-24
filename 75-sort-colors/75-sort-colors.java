class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return;
        
        int start = 0, index = 0, end = nums.length - 1;
        
        while(index <= end && start < end) {
            if(nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            }else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }else {
                index++;
            }
        }
    }
}
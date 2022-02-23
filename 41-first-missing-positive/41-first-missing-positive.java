class Solution {
    public int firstMissingPositive(int[] nums) {
        int c = 0;
        for(int i = 0; i < nums.length; i++) 
            if(nums[i] == 1) {
                c++;
                break;
            }
            if(c == 0) return 1;
        
            for(int i = 0; i < nums.length; i++)
                if(nums[i] <= 0 || nums[i] > nums.length)
                    nums[i] = 1;
            
            for(int i = 0; i < nums.length; i++) {
                int abs = Math.abs(nums[i]);
                
                if(abs == nums.length)
                    nums[0] = -Math.abs(nums[0]);
                else
                    nums[abs] = -Math.abs(nums[abs]);
            }
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] > 0)
                    return i;
            }
            if(nums[0] > 0)
                return nums.length;
        
        return nums.length + 1;
    }
}
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) 
            return nums[0];
        int[] n = new int[1001] ;
        for(int i: nums)
            n[i] += i;
        
        int twoBack = n[0];
        int oneBack = Math.max(twoBack, n[1]);
        int temp = oneBack;
        for(int i = 2; i < n.length; i++){
            temp = Math.max(n[i] + twoBack, oneBack);
            twoBack = oneBack;
            oneBack = temp;
        }
        return temp;
    }
}
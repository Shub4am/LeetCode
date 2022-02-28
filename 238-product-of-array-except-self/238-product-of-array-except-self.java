class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] answer = new int[nums.length];
        answer[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1]* nums[i - 1];
        }
        int e = 1;
        for(int i = nums.length - 2; i > -1; i--) {
            answer[i]*= nums[i + 1]*e;
            e*= nums[i + 1];
        }
        return answer;
    }
}
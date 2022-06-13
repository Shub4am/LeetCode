class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0, curr = 0;
        for(int i = 0, j = 0; j < nums.length; j++){
            curr += nums[j];
            while(curr * (j - i + 1) >= k)
                curr -= nums[i++];
            res += j - i + 1;
        } 
        return res;
    }
}
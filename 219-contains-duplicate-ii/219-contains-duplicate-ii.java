class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> res = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) 
                res.remove(nums[i- k - 1]);
            if(!res.add(nums[i])) 
                return true;
        }
        return false;
 }
}
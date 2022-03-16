class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        
        for(int i= 0; i < nums.length; i++){
            if(hashSet.contains(nums[i]))
                return true;
            hashSet.add(nums[i]);
        }
        return false;
    }
}
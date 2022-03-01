class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0, 1);
        int sum = 0, res = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if(hashmap.containsKey(sum - k))
                res += hashmap.get(sum -k);
            hashmap.put(sum, hashmap.getOrDefault(sum, 0) + 1);
            
            
        }
        return res;
    }
}
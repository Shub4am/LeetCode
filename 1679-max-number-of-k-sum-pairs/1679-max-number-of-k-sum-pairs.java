class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        int count = 0;
        for(int i : nums){
            if(hashmap.containsKey(i) && hashmap.get(i) > 0){
                count++;
                hashmap.put(i , hashmap.get(i) - 1);
            }
            else{
                hashmap.put(k - i, hashmap.getOrDefault(k - i, 0) + 1);
            }
        }
        return count;
    }
}
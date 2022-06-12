class Solution {
    public int maximumUniqueSubarray(int[] nums) {
      Map<Integer, Integer> hashMap = new HashMap<>();
        int left = 0, res = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            int i = nums[right];
            if (hashMap.containsKey(i)) {
                int index = hashMap.get(i);
                while (left <= index) {
                    hashMap.remove(nums[left]);
                    sum -= nums[left];
                    left += 1;
                }
            }
            hashMap.put(i, right);
            sum += i;
            res = Math.max(res, sum);
        }
        return res;  
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
    int len = nums.length;
    List<String> result = new ArrayList<String>(len);
    for (int i = 0; i < len; i++) {
        int num = nums[i];
        while (i < len - 1 && nums[i] + 1 == nums[i + 1]) {
            i++;
        }
        if (num != nums[i]) {
            result.add(num + "->" + nums[i]);
        } else {
            result.add(num + "");
        }
    }
    return result;
}
}
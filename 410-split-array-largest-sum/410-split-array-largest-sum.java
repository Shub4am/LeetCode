class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int element : nums) {
            sum += element;
            maxElement = Math.max(maxElement, element);
        }
        int left = maxElement;
        int right = sum;
        int minimumLargestSplitSum = 0;
        while (left <= right) {
            int maxSumAllowed = left + (right - left) / 2;
            if (minimumSubarraysRequired(nums, maxSumAllowed) <= m) {
                right = maxSumAllowed - 1;
                minimumLargestSplitSum = maxSumAllowed;
            } else {
                left = maxSumAllowed + 1;
            }
        }
        return minimumLargestSplitSum;
    }
    private int minimumSubarraysRequired(int[] nums, int maxSumAllowed) {
        int currentSum = 0;
        int splitsRequired = 0;
        
        for (int element : nums) {
            if (currentSum + element <= maxSumAllowed) {
                currentSum += element;
            } else {
                currentSum = element;
                splitsRequired++;
            }
        }
        return splitsRequired + 1;
    }
}
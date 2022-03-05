class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        int twoBack = 0;
        int oneBack = hashMap.getOrDefault(1, 0);
        for (int num = 2; num <= maxNumber; num++) {
            int temp = oneBack;
            oneBack = Math.max(oneBack, twoBack + hashMap.getOrDefault(num, 0));
            twoBack = temp;
        }
        return oneBack;
    }
}
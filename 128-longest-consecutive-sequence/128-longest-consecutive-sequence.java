class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int longestSequence = 0;
        for(int i : set){
            if(!set.contains(i - 1)){
                int curr = i;
                int currStreak = 1;
                while(set.contains(curr + 1)){
                    curr += 1;
                    currStreak += 1; 
                }
                longestSequence = Math.max(longestSequence, currStreak);
            }
        }
        return longestSequence;
    }
}
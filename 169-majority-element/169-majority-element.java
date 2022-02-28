//Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer element = null;
        for(int i : nums) {
            if(count == 0)
                element = i;
            count+=(i == element) ? 1 : -1;
        }
        return element;
    }
}
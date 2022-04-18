class Solution {
    public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i: nums) 
            if(Math.abs(i) < Math.abs(res) || i == Math.abs(res)) res = i;
        return res;
    }
}
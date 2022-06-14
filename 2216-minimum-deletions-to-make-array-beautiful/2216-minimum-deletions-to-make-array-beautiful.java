class Solution {
    public int minDeletion(int[] nums) {
        int res = 0, prev = -1;
        for (int i : nums) {
            if (i == prev)
                res++;
            else
                prev = prev < 0 ? i : -1;
        }
        return prev < 0 ? res : res + 1;
    }
}
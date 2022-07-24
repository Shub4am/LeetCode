class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap <Integer,Integer> [] hashMap = new HashMap[nums.length];
        for(int i = 0; i < nums.length; i++)
            hashMap[i] = new HashMap <>();
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                long n = (long)nums[i] - (long)nums[j];
                if(n <= Integer.MIN_VALUE || n >= Integer.MAX_VALUE) continue;
                int endingAtj = hashMap[j].getOrDefault((int)n, 0);
                int endingAti = hashMap[i].getOrDefault((int)n, 0);
                res += endingAtj;
                hashMap[i].put((int) n, endingAtj + endingAti + 1);
            }
        }
        return res;
    }
}
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int i: batteries)
            sum += i;
        int k = 0, na = batteries.length;
        while (batteries[na - 1 - k] > sum / (n - k))
            sum -= batteries[na - 1 - k++];
        return sum / (n - k);
    }
}
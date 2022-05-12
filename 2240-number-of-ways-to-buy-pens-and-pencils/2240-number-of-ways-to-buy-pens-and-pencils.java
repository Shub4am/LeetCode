class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for(; total >= 0; total -= cost1)
            res += total / cost2 + 1;
        return res;
    }
}
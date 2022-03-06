class Solution {
    public int countOrders(int n) {
        long res = 1;
        int MOD = 1_000_000_007;
        for(int i = 1; i <= 2 * n; ++i){
            res = res * i;
            if(i % 2 == 0){
                res = res / 2;
            }
            res %= MOD;
        }
        return (int)res;
    }
}
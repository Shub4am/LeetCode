class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countTops = new int[7], countBottoms = new int[7], countSame = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            int a = tops[i], b = bottoms[i];
            countTops[a] += 1;
            countBottoms[b] += 1;
            if (a == b) countSame[a] += 1;
        }
        int res = n;
        for (int v = 1; v <= 6; v++) {
            if (countTops[v] + countBottoms[v] - countSame[v] == n) {
                int minSwap = Math.min(countTops[v], countBottoms[v]) - countSame[v];
                res = Math.min(res, minSwap);
            }
        }   
        return res == n ? -1 : res;
    }
}
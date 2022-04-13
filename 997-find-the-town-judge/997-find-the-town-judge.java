class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for(int[] i : trust){
            count[i[0]]--;
            count[i[1]]++;
        }
        for(int i = 1; i <= n; ++i){
            if(count[i] == n - 1)
                return i;
        }
        return -1;
    }
}
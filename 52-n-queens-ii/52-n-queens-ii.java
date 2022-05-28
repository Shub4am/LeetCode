class Solution {
    int res;
    public int totalNQueens(int n) {
        res = 0;
        place(0,0,0,0,n);
        return res;
    }
    private void place(int i, int vert, int ldiag, int rdiag, int n) {
        if (i == n) 
            res++;
        else for (int j = 0; j < n; j++) {
            int vmask = 1 << j, lmask = 1 << (i + j), rmask = 1 << (n - i - 1 + j);
            if ((vert & vmask) + (ldiag & lmask) + (rdiag & rmask) > 0) 
                continue;
            place(i+1, vert | vmask, ldiag | lmask, rdiag | rmask, n);
        }
    }
}
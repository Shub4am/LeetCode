class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int res = 0;
        for (int i = 0; i < 4; i++){
            res = Math.max(res, solve(grid));
            grid = rotate(grid);
        }
        return res;
    }

    private int solve(int[][] grid){
        int n = grid[0].length, m = grid.length, res = 0;
        int[][] fCol = new int[m + 1][n];
        int[][] tCol = new int[m + 1][n];
        int[][] fRow = new int[n + 1][m];
        int[][] tRow = new int[n + 1][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int t = count(grid[i][j], 2);
                int f = count(grid[i][j], 5);
                fCol[i + 1][j] += fCol[i][j] + f;
                tCol[i + 1][j] += tCol[i][j] + t;
                fRow[j + 1][i] += fRow[j][i] + f;
                tRow[j + 1][i] += tRow[j][i] + t;
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int rowTwo = tRow[j + 1][i];
                int rowFive= fRow[j + 1][i];
                int colTwo = tCol[m][j] - tCol[i + 1][j];
                int colFive= fCol[m][j] - fCol[i + 1][j];
                res = Math.max(res, Math.min(rowTwo + colTwo, rowFive + colFive));
            }
        }

        return res;
    }

    private int count(int n, int w){
        int count = 0;
        while(n % w == 0){
            count++;
            n /= w;
        }
        return count;
    }

    private int[][] rotate(int[][] grid){
        int n = grid[0].length, m = grid.length;
        int[][] next = new int[n][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                next[j][m - 1 - i] = grid[i][j];
            }
        }
        return next;
    }
}
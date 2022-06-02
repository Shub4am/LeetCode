class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int [][]res = new int[n][m];
        for(int j = 0; j < n; j++)
            for(int i = 0; i < m; i++)
                res[j][i] = matrix[i][j];
        return res;
    }
}
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if((rows * cols) != (r * c))
            return mat;
        int[][] res = new int[r][c];
        int rowMat = 0, colMat = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                res[rowMat][colMat] = mat[i][j];
                colMat++;
                if(colMat == c){
                    colMat = 0;
                    rowMat++;
                }
            }
        }
        return res;
    }
}
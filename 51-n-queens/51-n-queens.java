class Solution {
    public List<String> constructString(char[][] board) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public void nQueens(char[][] board, int row, boolean[]columns, boolean [] normalDiagonal, boolean [] reverseDiagonal, List<List<String>> result){
        if(row==board.length){
            result.add(constructString(board));
            return;
        }
        for(int col=0;col<board[0].length;col++){
            if(columns[col]==false && normalDiagonal[row+col]==false && reverseDiagonal[row-col+board.length-1]==false){
                board[row][col]= 'Q';
                columns[col]=true;
                normalDiagonal[row+col]=true;
                reverseDiagonal[row-col+board.length-1]=true;
                nQueens(board, row+1, columns, normalDiagonal, reverseDiagonal, result);
                board[row][col]= '.';
                columns[col]=false;
                normalDiagonal[row+col]=false;
                reverseDiagonal[row-col+board.length-1]=false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                board[row][col]='.';
            }
        }
        boolean [] columns = new boolean[n];
        boolean [] normalDiagonal = new boolean[2*n-1];
        boolean [] reverseDiagonal = new boolean[2*n-1];
        nQueens(board, 0, columns, normalDiagonal, reverseDiagonal, result);
        return result;
    }
}
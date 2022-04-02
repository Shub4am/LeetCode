class Solution {  
    public int closedIsland(int[][] grid) {
        int count = 0; 
        for(int i = 0;i < grid.length;i++){
           for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 0){
                       count += dfs(grid,i,j);
                }
           }
        }
        return count;
    }
    private int dfs(int[][] grid,int rows,int cols){
         if(rows < 0 || rows >= grid.length || cols < 0 || cols >= grid[0].length){
                 return 0;
         }
         if(grid[rows][cols] == 1){
                 return 1;
         }
         grid[rows][cols] = 1;
         int up = dfs(grid, rows - 1, cols);
         int down = dfs(grid, rows + 1, cols);
         int left = dfs(grid, rows, cols - 1);
         int right = dfs(grid, rows, cols + 1);
         return up & down & left & right;
    }
}
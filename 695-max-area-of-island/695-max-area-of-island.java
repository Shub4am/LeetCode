class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int  i =0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)
                    maxArea = Math.max(maxArea, AreaOfIsland(grid, i, j));
        return maxArea;
    }
    public int AreaOfIsland(int[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i + 1, j) +  AreaOfIsland(grid, i - 1, j) + AreaOfIsland(grid, i, j + 1) + AreaOfIsland(grid, i, j - 1) ; 
        }
        return 0;
    }
}
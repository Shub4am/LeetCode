class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && vis[i][j] == false) {
                    callDFS(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void callDFS(char[][]grid, boolean[][]vis, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] == true || grid[i][j] == '0') 
            return;
        
        vis[i][j] = true;
        callDFS(grid, vis, i + 1, j);
        callDFS(grid, vis, i - 1, j);
        callDFS(grid, vis, i, j - 1);
        callDFS(grid, vis, i, j + 1);
        
    }
}
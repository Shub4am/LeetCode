class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = {{1,1},{1,0},{0,1},{1,-1},{-1,1},{-1,0},{0,-1},{-1,-1}};
        Queue<int[]> map =new LinkedList<>();
        int rMax = grid.length;
        int cMax = grid[0].length;
        if(grid[0][0]==1) return -1; 
        map.offer(new int[] {0,0,1});
        while(!map.isEmpty()){
            int[] location = map.poll();
            int r = location[0];
            int c = location[1];
            int distance = location[2];
            if(r==rMax-1 && c==cMax-1) return distance;
            for(int[] d : dir){
                int r2 = r + d[0];
                int c2 = c + d[1];
                if(r2<rMax && r2>=0 && c2<cMax && c2>=0 && grid[r2][c2]==0){
                    map.offer(new int[] {r2,c2,distance+1});
                    grid[r2][c2] = 1;
                }
            }
        }   
        return -1;
    }
}
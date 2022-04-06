class Solution {
    final char wall = '+';
    final char empty = '.';
    final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = wall;
        q.offer(entrance);
        while(!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] c = q.poll();
                for (int[] dir: dirs) {
                    int x = c[0] + dir[0];
                    int y = c[1] + dir[1];
                    if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] != empty) continue;                   
                    if (x == 0 || y == 0 || (x == maze.length - 1) || (y == maze[0].length - 1)) return result;
                    maze[x][y] = wall;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
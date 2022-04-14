class Solution {
    public boolean isBipartite(int[][] graph) {        
        int n = graph.length, colors[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) 
                return false;            
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] colors, int i, int color) {
        colors[i] = color;
        for (int j = 0; j < graph[i].length; j++) {
            int k = graph[i][j];
            if (colors[k] == -color) 
                continue;
            if (colors[k] == color || !dfs(graph, colors, k, -color)) 
                return false;
        }
        return true;
    }
}
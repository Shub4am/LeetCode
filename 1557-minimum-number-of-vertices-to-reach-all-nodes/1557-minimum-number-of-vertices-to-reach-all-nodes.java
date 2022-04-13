class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        int [] vis = new int[n];
        for(List<Integer> i: edges)
            vis[i.get(1)] = 1;
        for(int i = 0; i < n; ++i)
            if(vis[i] == 0) 
                res.add(i);
        return res;
    }
}
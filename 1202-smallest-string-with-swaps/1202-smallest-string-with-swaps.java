class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for(List<Integer> list:pairs)
            uf.union(list.get(0),list.get(1));
        
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int r = uf.find(i);
            map.putIfAbsent(r,new PriorityQueue<Character>());
            map.get(r).offer(s.charAt(i));
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++){
            int r = uf.find(i);
            stringBuilder.append(map.get(r).poll());
        }
        return stringBuilder.toString();
        
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++)
            root[i] = i;
    }

	public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

	public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
}
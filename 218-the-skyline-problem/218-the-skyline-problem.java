class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length, STT = 1, END = -1, idx = 0;
        int[][] cor = new int[2*n][3];
        for (int[] b : buildings){
            cor[idx++] = new int[]{STT, b[0], b[2]};
            cor[idx++] = new int[]{END, b[1], b[2]};
        }

        Arrays.sort(cor, (a, b) ->{
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] == STT && b[0] == STT) return Integer.compare(b[2], a[2]);
            if (a[0] == END && b[0] == END) return Integer.compare(a[2], b[2]);
            return Integer.compare(b[0], a[0]);
        });

        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int max = 0;
        for (int[] c : cor){
            int type = c[0], x = c[1], y = c[2];
			if (cntMap.merge(y, type, Integer::sum) == 0) cntMap.remove(y);
            int curMax = cntMap.isEmpty()? 0 : cntMap.lastKey();
            if (curMax != max){
                max = curMax;
                ans.add(List.of(x, max));
            }
        }

        return ans;
    }
}
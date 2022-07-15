class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> d = new TreeMap<>();
        for (int[] a : segments) {
            d.put(a[0], d.getOrDefault(a[0], 0L) + a[2]);
            d.put(a[1], d.getOrDefault(a[1], 0L) - a[2]);
        }
        List<List<Long>> res = new ArrayList<>();;
        long i = 0, sum = 0;
        for (int j : d.keySet()) {
            if (sum > 0)
                res.add(Arrays.asList(i, (long)j, sum));
            sum += d.get(j);
            i = j;
        }
        return res;
    }
}
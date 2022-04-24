class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int[] n : nums) {
            for (int i : n) {
                count.put(i, count.getOrDefault(i, 0) + 1);
                if (count.get(i) == nums.length) res.add(i);
            }
        }
        res.sort(Comparator.naturalOrder());
        return res;
    }
}
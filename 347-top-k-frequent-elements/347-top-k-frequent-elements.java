class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry entry : map.entrySet()){
            pQueue.add(entry);
        }
        int[] output = new int[k];
        for(int i = 0; i < k; i++) {
            output[i] = pQueue.poll().getKey();
        }
        return output;
    }
}
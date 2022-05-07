class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; i++){
            if(hashmap.containsKey(cards[i]))
                min = Math.min(i - hashmap.get(cards[i]) + 1, min);
            hashmap.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        long total = 0;
        for (int t : target) {
            total += t;
            pq.add(t);
        }
        while (true) {
            int t = pq.poll();
            total -= t;
            if (t == 1 || total == 1)
                return true;
            if (t < total || total == 0 || t % total == 0)
                return false;
            t %= total;
            total += t;
            pq.add(t);
        }
    }
}
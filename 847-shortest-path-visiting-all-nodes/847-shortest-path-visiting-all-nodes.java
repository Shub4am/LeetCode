class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length, mask = 1, count = 0;
        Set<String> hashSet = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            mask |= (1 << i);
            int[] make = new int[] {(1<<i),i};
            hashSet.add(make[0] + "+" + make[1]);
            queue.offer(make);
        }
        while (true) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] curr = queue.poll();
                if (curr[0] == mask) return count;
                for (int next : graph[curr[1]]) {
                    int nextPath = curr[0] | (1 << next);
                    if (!hashSet.add(nextPath + "+" + next)) continue;
                    queue.offer(new int[]{nextPath,next});
                }
            }
            count++;
        }
    }
}
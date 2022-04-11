class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)-> a1[0] - a2[0]);
        pq.offer(new int[]{0,0,0});
        Set<Integer> forbit = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int maxLimit = 2000 + 2 * b;
        for(int num : forbidden){
            forbit.add(num);
            maxLimit = Math.max(maxLimit, num + 2 * b);
        }
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int step = node[0];
            int idx = node[1];
            int dir = node[2];
            if(idx == x) return step;
			
            if(idx+a < maxLimit && !forbit.contains(idx+a) && !visited.contains(idx+a+","+0)){
                visited.add(idx+a+","+0);
                pq.offer(new int[]{step+1, idx+a, 0});
            }
			//try jump back
            if(idx-b >= 0 && !forbit.contains(idx-b) && !visited.contains(idx-b+","+1) && dir != 1){
                visited.add(idx-b+","+1);
                pq.offer(new int[]{step+1, idx-b, 1});
            }
        }
        return -1;
    }
}
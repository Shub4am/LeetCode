class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < persons.length; i++){
            pq.offer(new int[]{persons[i], 1, i});
        }
        for(int[] flower : flowers){
            pq.offer(new int[]{flower[0], 0});
            pq.offer(new int[]{flower[1], 2});
        }
        int[] ret = new int[persons.length];
        int numEvents = pq.size();
        int blooms = 0;
        for(int i = 0; i < numEvents; i++){
            int[] cur = pq.poll();
            if(cur[1] == 0){
                blooms++;
            }else if(cur[1] == 2){
                blooms--;
            }else{
			    int personIndex = cur[2];
                ret[personIndex] = blooms;
            }
        }
        return ret;
    }
}
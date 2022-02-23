class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> outputArray = new LinkedList<>();
        for(int [] interval : intervals) {
            if(outputArray.isEmpty() || outputArray.getLast()[1] < interval [0]) {
                outputArray.add(interval);
            }
            else {
                outputArray.getLast()[1] = Math.max(outputArray.getLast()[1], interval[1]);
            }
        }
        return outputArray.toArray(new int[outputArray.size()][]);
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] {newInterval};
        LinkedList<int []> mergedIntervals = new LinkedList();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0])
            mergedIntervals.add(intervals[i++]);
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);
        while (i < intervals.length)
            mergedIntervals.add(intervals[i++]);        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
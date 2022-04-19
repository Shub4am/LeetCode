class Solution {
    public class Point {
        private int val;
        private int idx;
        private Point(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Point[] points = new Point[nums.length];
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            points[i] = new Point(nums[i], i);
            map.put(points[i], 0);
        }
        mergeSort(points, 0, nums.length - 1, map);
        Integer[] temp = new Integer[nums.length];
        for (Point p : map.keySet()) {
            temp[p.idx] = map.get(p);
        }
        return Arrays.asList(temp);
    }
    public void mergeSort(Point[] points, int start, int end, Map<Point, Integer> map) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(points, start, mid, map);
        mergeSort(points, mid + 1, end, map);
        List<Point> list = new ArrayList<>();
        int left = start;
        int right = mid + 1;
        int countOfSmallerRight = 0;
        while (left <= mid && right <= end) {
            if (points[left].val <= points[right].val) {
                map.put(points[left], map.get(points[left]) + countOfSmallerRight);
                list.add(points[left]);
                left++;
            } else {
                countOfSmallerRight++;
                list.add(points[right]);
                right++;
            }
        }
        while (left <= mid) {
            map.put(points[left], map.get(points[left]) + countOfSmallerRight);
            list.add(points[left]);
            left++;
        }
        while (right <= end) {
            countOfSmallerRight++;
            //
            list.add(points[right]);
            right++;
        }
        for (int i = start; i <= end; i++) {
            points[i] = list.get(i - start);
        }
    }
}
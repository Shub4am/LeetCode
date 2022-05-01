class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k);
    }
    private int[][] quickSelect(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k) {
                left = pivotIndex;
            } else {
                right = pivotIndex - 1;
            }
        }
        return Arrays.copyOf(points, k);
    }
    private int partition(int[][] points, int left, int right) {
        int[] pivot = choosePivot(points, left, right);
        int pivotDist = squaredDistance(pivot);
        while (left < right) {
            if (squaredDistance(points[left]) >= pivotDist) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp; 
                right--;
            } else {
                left++;
            }
        }
        if (squaredDistance(points[left]) < pivotDist)
            left++;
        return left;
    }
    private int[] choosePivot(int[][] points, int left, int right) {
        return points[left + (right - left) / 2];
    }
    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
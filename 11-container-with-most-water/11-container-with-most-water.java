class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0; 
        int left =0;
        int right = height.length-1;
        while(left < right) {
            if(height[left] < height[right]) {
                maxArea = Math.max(maxArea, height[left]*(right-left));
                left++;
            }else {
                maxArea = Math.max(maxArea, height[right]*(right-left));
                right--;
            }
        }
        return maxArea;
    }
}
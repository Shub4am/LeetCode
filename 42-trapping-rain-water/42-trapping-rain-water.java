class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        
        int max = height[n - 1];
        for(int i = n - 1; i >=0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        
        int ans = 0;
        int leftMax = height[0];
        for(int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            ans += Math.min(leftMax, rightMax[i]) - height[i];
        }
        return ans;
    }
}
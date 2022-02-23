class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length;
        int n = nums2.length; 
        int lo = 0, hi = m;
        
        while(lo <= hi) {
            int partX = (lo+hi) / 2;
            int partY = (m + n + 1) / 2 - partX; 
            
        
            int leftX = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            int leftY = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1]; 
            
            int rightX = partX == m ? Integer.MAX_VALUE : nums1[partX];
            int rightY = partY == n ? Integer.MAX_VALUE : nums2[partY]; 
            
            
            if(leftX <= rightY && leftY <= rightX) {
                if( (m + n) % 2 == 0 ) 
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0; 
                else 
                    return Math.max(leftX, leftY); 
            }
            else if(leftX > rightY) {
                hi = partX - 1; 
            }
            else {
                lo = partX + 1; 
            }
        }
        return 0.0; 
    }
}
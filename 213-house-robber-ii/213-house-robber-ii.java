class Solution {
    public int rec(int i,int start,int arr[],int dp[]){
        if(i>=arr.length)
            return 0;
        if(i==arr.length-1&&start==0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        return dp[i]=Math.max(rec(i+1,start,arr,dp),arr[i]+rec(i+2,start,arr,dp));
    }
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int result=rec(0,0,nums,dp);
        Arrays.fill(dp,-1);
        result=Math.max(result,rec(1,1,nums,dp));
        return result;
    }
}
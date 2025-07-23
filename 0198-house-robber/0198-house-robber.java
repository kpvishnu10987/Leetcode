class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return f(nums,dp,n-1);
    }
    private int f(int[] nums,int[] dp,int ind){
        if(ind < 0) return 0;
        if(ind == 0) return nums[ind];
        if(dp[ind] != -1) return dp[ind];

        dp[ind] = Math.max(nums[ind]+f(nums,dp,ind-2),f(nums,dp,ind-1));
        return dp[ind];
    }

}
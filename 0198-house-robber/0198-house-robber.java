class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,nums);
    }

    private int solve(int i , int[] nums){
        if( i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        int ns = nums[i] + solve(i+2,nums);
        int s = solve(i+1,nums);
        int best = Math.max(ns,s);
        return dp[i] = best;
        
    }
}
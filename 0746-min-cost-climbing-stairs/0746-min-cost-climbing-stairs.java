class Solution {
    int[] cost;
    int[] dp;
    int n;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        n = cost.length;
        dp =new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2 ; i<n ; i++){
            int one = cost[i] + dp[i-1];
            int two = cost[i] + dp[i-2];
            dp[i] = Math.min(one,two);
        }

        return Math.min(dp[n-1],dp[n-2]);
    }
    
}
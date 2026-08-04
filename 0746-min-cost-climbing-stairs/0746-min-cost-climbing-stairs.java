class Solution {
    int[] cost;
    int[] dp;
    int n;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        n = cost.length;
        dp =new int[n];

        Arrays.fill(dp,-1);

        return Math.min(f(0),f(1));
    }
    private int f(int i){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];

        int one = cost[i] + f(i+1);
        int two = cost[i] + f(i+2);

        return dp[i] = Math.min(one,two);
    }
}
class Solution {
    int[][] dp;
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;

        dp = new int[n][3];

        
            for(int[] row : dp){
                Arrays.fill(row,-1);
            }
        

        return solve(0,2,prices);
    }

    private int solve(int i,int buy,int[] prices){
        if(i == n) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 2){
            int take = -prices[i] + solve(i+1,0,prices);
            int skip = solve(i+1,2,prices);
            return dp[i][buy] = Math.max(take,skip);
        }else if(buy == 0){
            int sell = prices[i] + solve(i+1,1,prices);
            int hold = solve(i+1,0,prices);
            return dp[i][buy] = Math.max(sell,hold);
        }else{
            return dp[i][buy] = solve(i+1,2,prices);
        }


    }
}
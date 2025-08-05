class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][k+1];
        int profit = 0;
        for(int i = n-1 ; i>=0 ; i--){
            for(int canBuy = 0 ; canBuy <= 1 ; canBuy++){
                for(int cap = 1 ; cap <=k ; cap++){
                    if(canBuy == 1){
                        int buy = -prices[i] + dp[i+1][0][cap];
                        int skip = dp[i+1][1][cap];
                        profit = Math.max(buy,skip);
                    }else{
                        int sell = prices[i] + dp[i+1][1][cap-1];
                        int skip = dp[i+1][0][cap];
                        profit = Math.max(sell,skip);
                    }
                    dp[i][canBuy][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
}
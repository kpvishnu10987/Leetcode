class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int am = coin ; am <= amount ; am++){
                dp[am] += dp[am-coin];
            }
        }        
        return dp[amount];
    }
}
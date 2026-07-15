class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int dp[][] = new int[n][amount+1];

        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = 1;
        }

        for(int i = 1 ; i<n ; i++){
            for(int j = 0 ; j<= amount ; j++){
                if(coins[i] <= j){
                    dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][amount];
    }
}
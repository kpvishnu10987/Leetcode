class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int num : coins){
            for(int i = num ; i<=amount ; i++){
                if(num <= amount){
                    dp[i] = Math.min(dp[i],1+dp[i-num]);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
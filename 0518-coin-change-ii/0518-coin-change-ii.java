class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n][amount+1];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        return f(0,amount,coins);
    }

    private int f(int i,int amount,int[] coins){
        if(amount == 0){
            return 1;
        }

        if(i == n) return 0;

        if(dp[i][amount] != -1) return dp[i][amount];

        int ans = 0;

        for(int start = i; start<n ; start++){
            if(coins[start] > amount) continue;
            ans += f(start,amount-coins[start],coins);
        }

        return dp[i][amount] = ans;
    }
}
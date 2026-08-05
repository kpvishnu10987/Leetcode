class Solution {
    int[] coins;
    int[][] dp;
    int n;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        n = coins.length;
        dp = new int[n][amount+1];
        for(int[] r : dp) Arrays.fill(r,-1);

        return f(0,amount);
    }

    private int f(int i,int amount){
        if(amount == 0) return 1;
        if(i == n || amount < 0) return 0;

        if(dp[i][amount] != -1) return dp[i][amount];

        int ans = 0;

        

        return dp[i][amount] = f(i+1,amount) + f(i,amount-coins[i]);
    }
}
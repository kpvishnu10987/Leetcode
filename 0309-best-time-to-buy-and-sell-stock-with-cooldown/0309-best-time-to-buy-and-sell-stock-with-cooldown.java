class Solution {
    int n;
    int[] prices;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        n = prices.length;
        dp = new int[n][3];

        for(int[] r : dp) Arrays.fill(r,-1);

        return f(0,0);
        
    }
    private int f(int code,int i){
        if(i == n) return 0;

        if(dp[i][code] != -1) return dp[i][code];

        if(code == 0){
            int b = -prices[i] + f(1,i+1);
            int nb = f(0,i+1);
            return dp[i][code] = Math.max(b,nb);
        }else if(code == 1){
            int s = prices[i] + f(2,i+1);
            int ns = f(1,i+1);
            return dp[i][code] = Math.max(s,ns);
        }

        return dp[i][code] = f(0,i+1);
    }
}
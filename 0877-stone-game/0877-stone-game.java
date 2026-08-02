class Solution {
    int[] piles;
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        int n = piles.length;

        dp = new int[n][n];

        for(int [] r: dp) Arrays.fill(r,-1);

        return f(0,n-1) > 0;
    }
    private int f(int i,int j){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int start = piles[i] - f(i+1,j);
        int end = piles[j] - f(i,j-1);

        return dp[i][j] = Math.max(start,end);
    }
}
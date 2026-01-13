class Solution {
    int[][] dp;
    int m,n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];

        for(int i = 0  ;i<m ;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(0,0);
    }
    private int f(int i,int j){
        if(i >= m || j>=n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = f(i+1,j)+f(i,j+1); 
    }
}
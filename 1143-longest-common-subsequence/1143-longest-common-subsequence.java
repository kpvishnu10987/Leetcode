class Solution {
    String s1;
    String s2;
    int n;
    int m;
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        this.s1 = text1;
        this.s2 = text2;
        n = text1.length();
        m = text2.length();
        dp  = new int[n][m];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        return dfs(0,0);
    }

    private int dfs(int i,int j){
        if(i == n || j == m) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + dfs(i+1,j+1);
        }

        return dp[i][j] = Math.max(dfs(i+1,j),dfs(i,j+1));
    }
}
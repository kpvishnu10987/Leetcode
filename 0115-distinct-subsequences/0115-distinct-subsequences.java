class Solution {
    String s;
    String t;
    int n;
    int m;
    int[][] dp;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        n = s.length();
        m = t.length();
        dp = new int[n][m];
        for(int r[] : dp) Arrays.fill(r,-1);

        return f(0,0);
    }
    private int f(int i,int j){
        if(j == m) return 1;
        if(i == n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        if(s.charAt(i) == t.charAt(j)){
            ans += f(i+1,j+1);
        }
        ans += f(i+1,j);
        

        return dp[i][j] = ans;
    }
}
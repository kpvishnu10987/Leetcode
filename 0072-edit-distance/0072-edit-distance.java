class Solution {
    String s;
    String t;
    int n;
    int m;
    int[][] dp;
    public int minDistance(String s, String t) {
        this.s = s;
        this.t = t;
        n = s.length();
        m = t.length();

        dp = new int[n][m];
        for(int[] r : dp) Arrays.fill(r,-1);

        return f(0,0);
        
    }
    private int f(int i,int j){
        if(i == n) return m-j;
        if(j == m) return n-i;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return f(i+1,j+1);
        }

        int ins = 1 + f(i,j+1);
        int del = 1 + f(i+1,j);
        int rep = 1 + f(i+1,j+1);

        return dp[i][j] = Math.min(ins,Math.min(del,rep));
    }

}
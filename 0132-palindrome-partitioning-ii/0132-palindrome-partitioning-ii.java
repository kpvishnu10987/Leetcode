class Solution {
    String s;
    int[][] dp;
    public int minCut(String s) {
        int n = s.length();
        this.s = s;
        dp = new int[n][n];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        return f(0,n-1);
    }

    private int f(int i,int j){
        if(i >= j) return 0;
        if(isPalin(s,i,j)) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ways = Integer.MAX_VALUE;

        for(int k = i; k<j ; k++){
            if(isPalin(s,i,k)){
                ways = Math.min(ways,1 + f(k+1,j));
            }
        }

        return dp[i][j] = ways;
    }

    private boolean isPalin(String s,int i,int j){
        int l = i;
        int r = j;

        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
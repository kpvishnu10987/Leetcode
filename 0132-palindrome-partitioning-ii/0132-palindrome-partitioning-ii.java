class Solution {
    boolean[][] isPalin;
    int[] memo;
    String s;
    public int minCut(String s) {
        int n = s.length();
        this.s = s;
        isPalin = new boolean[n][n];
        memo = new int[n];
        Arrays.fill(memo,-1);
        for(int i = n-1; i>=0 ; i--){
            for(int j = i ; j<n ; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || isPalin[i+1][j-1])){
                    isPalin[i][j] = true;
                }
            }
        }

        return dp(0);
    }
    private int dp(int i){
        int n = s.length();
        if(isPalin[i][n-1]) return 0;
        if(memo[i] != -1) return memo[i];

        int min = Integer.MAX_VALUE;

        for(int k = i ;k<n ; k++){
            if(isPalin[i][k]){
                int cuts = 1+dp(k+1);
                min = Math.min(cuts,min);
            }
        }

        return memo[i] = min;
    }
}
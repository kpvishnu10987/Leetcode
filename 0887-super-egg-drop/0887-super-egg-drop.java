class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];

        int moves = 0;

        while(dp[moves][k] < n){
            moves++;

            for(int e = 1 ; e <= k ; e++){
                dp[moves][e] = 1 + dp[moves-1][e-1] + dp[moves-1][e];
            }
        }

        return moves;
        
    }
}
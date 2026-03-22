class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int total = 0;

        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m ; j++){
                total += helper(i,j,matrix,dp);
            }
        }

        return total;
    }

    private int helper(int i,int j,int[][] matrix,int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(matrix[i][j] == 0) return 0;

        int up = helper(i-1,j,matrix,dp);
        int left = helper(i,j-1,matrix,dp);
        int dig = helper(i-1,j-1,matrix,dp);

        dp[i][j] = 1+Math.min(up,Math.min(left,dig));
        return dp[i][j];
    }
}
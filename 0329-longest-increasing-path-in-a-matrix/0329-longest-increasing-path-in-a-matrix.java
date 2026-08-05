class Solution {
    int max = 1;
    int[][] dp;
    int n;
    int m;
    int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;

        dp = new int[n][m];
        for(int r[] : dp) Arrays.fill(r,-1);

        for(int i = 0 ;i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                dfs(i,j);
            }
        }
        return max;
    }
    private int dfs(int i,int j){
        if(dp[i][j] != -1) return dp[i][j];

        int[] drow = {0,-1,1,0};
        int[] dcol = {1,0,0,-1};

        int ans = 1;

        for(int k = 0 ; k < 4 ; k++){
            int nr = drow[k] + i;
            int nc = dcol[k] + j;
            if(nr >= 0 && nr < n && nc >=0 && nc <m){
                if(matrix[nr][nc] > matrix[i][j]){
                    ans = Math.max(ans,1 + dfs(nr,nc));
                    max = Math.max(ans,max);
                }
            }
        }

        return dp[i][j] = ans;
    }
}
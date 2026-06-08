class Solution {
    int[][] dp;
    int[][] matrix;
    int n, m;

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;
        int maxlen = 1;

        dp = new int[n][m];


        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j< m ; j++){
                maxlen = Math.max(maxlen,dfs(i,j));
            }
        }
        return maxlen;
    }
    private int dfs(int r,int c){
       if(dp[r][c] != 0) return dp[r][c];

       int len = 1;

       for(int i = 0 ; i<4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr <0 || nc < 0 || nr == n || nc == m) continue;

            if(matrix[nr][nc] > matrix[r][c]){
                len = Math.max(len , 1+dfs(nr,nc));
            }
       }

       return dp[r][c] = len;

    }
}
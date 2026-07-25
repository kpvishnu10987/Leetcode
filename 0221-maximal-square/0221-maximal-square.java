class Solution {
    int n;
    int m;
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;

        dp = new int[n][m];
        for(int[] r: dp){
            Arrays.fill(r,-1);
        }

        int side = 0;

        for(int i = 0 ;i<n ; i++){
            for(int j = 0 ;j<m ; j++){
                if(matrix[i][j] == '1')
                    side = Math.max(side,dfs(i,j,matrix));
            }
        }

        return side * side;
    }

    private int dfs(int i,int j,char[][] matrix){
        if(i > n-1 || j > m-1 || i <0 || j<0) return 0;

        if(matrix[i][j] == '0') return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int right = dfs(i,j+1,matrix);
        int down = dfs(i+1,j,matrix);
        int dia = dfs(i+1,j+1,matrix);

        return dp[i][j] = 1+Math.min(right,Math.min(down,dia));

    }
}
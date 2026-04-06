class Solution {
    int[][][] dp;
    int n;
    int m;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][m];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0; j<m ; j++){
                for(int k=0 ; k<m ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0,0,m-1,grid);
    }
    private int solve(int row,int c1,int c2,int[][] grid){
        if(c1 <0 || c1 >= m || c2<0 ||c2>=m) return 0;

        if(dp[row][c1][c2] != -1) return dp[row][c1][c2];

        int cherry;
        if(c1 == c2){
            cherry = grid[row][c2];
        }else{
            cherry = grid[row][c1]+grid[row][c2];
        }

        if(row == n-1){
            return dp[row][c1][c2] = cherry;
        }
        int max = 0;

        for(int d1 = -1; d1<=1 ; d1++){
            for(int d2 =-1 ; d2 <=1 ; d2++){
                int next = solve(row+1,c1+d1,c2+d2,grid);
                max = Math.max(next,max);
            }
        }

        return dp[row][c1][c2] = cherry + max;
    }
}
class Solution {
    int[][] grid;
    int n;
    int m;
    boolean[][] vis;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];

        int area = 0;

        for(int i = 0 ; i<n ;i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    area = Math.max(area,dfs(i,j));
                }
            }
        }

        return area;
    }

    private int dfs(int i,int j){
        if(i > n-1 || j > m-1 || i < 0 || j < 0) return 0;
        if(grid[i][j] == 0) return 0;
        if(vis[i][j]) return 0;
        vis[i][j] = true;


        int ans = 1;

        ans += dfs(i+1,j);
        ans += dfs(i,j+1);
        ans += dfs(i-1,j);
        ans += dfs(i,j-1);

        return ans;
    }
}
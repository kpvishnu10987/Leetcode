class Solution {
    int[] drow = {-1,1,0,0};
    int[] dcol = {0,0,-1,1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] at = new boolean[n][m];
        boolean[][] pa = new boolean[n][m];

        for(int i = 0 ; i<n ; i++){
            dfs(i,0,heights,pa);
            dfs(i,m-1,heights,at);
        }

        for(int i = 0 ; i<m ; i++){
            dfs(0,i,heights,pa);
            dfs(n-1,i,heights,at);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(pa[i][j] && at[i][j]){
                    ans.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }

        return ans;
    }

    private void dfs(int i,int j,int[][] grid,boolean[][] vis){
        if(vis[i][j]) return;
        vis[i][j] = true;

        for(int k = 0 ; k<4 ; k++){
            int r = i + drow[k];
            int c = j + dcol[k];
            if(r >=0 && r <grid.length && c >=0  && c < grid[0].length && vis[r][c] == false){
                if(grid[r][c] >= grid[i][j]){
                    dfs(r,c,grid,vis);
                }
            }
        }
    }
}
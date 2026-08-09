class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int islands = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j =0 ; j<m ; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(i,j,grid);
                }
            }
        }

        return islands;
    }

    private void dfs(int i,int j,char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] == '0') return;

        grid[i][j] = '0';


        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
    }
}
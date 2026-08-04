class Solution {
    char[][] grid;
    int n;
    int m;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;


        
        int comp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    comp++;
                    dfs(i,j);
                }
            }
        }

        return comp;

    }

    private void dfs(int i,int j){
        if(i < 0 || j < 0 || i > n-1 || j > m-1) return;

        if(grid[i][j] == '0') return;

        grid[i][j] = '0';

        dfs(i+1,j);
        dfs(i,j+1);
        dfs(i-1,j);
        dfs(i,j-1); 
    }
}
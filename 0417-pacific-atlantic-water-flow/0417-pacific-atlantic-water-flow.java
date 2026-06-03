class Solution {
    int n;
    int m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int c = 0; c < m; c++){
    dfs(0, c, pacific, heights);
    dfs(n - 1, c, atlantic, heights);
}

for(int r = 0; r < n; r++){
    dfs(r, 0, pacific, heights);
    dfs(r, m - 1, atlantic, heights);
}
        
        for(int i = 0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private void dfs(int i,int j,boolean[][] ocean,int[][] heights){
        ocean[i][j] = true;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int k = 0  ; k<4 ; k++){
            int r = drow[k] + i;
            int c = dcol[k] + j;

            if(r < 0 || r > n-1 || c < 0 || c > m-1 || ocean[r][c] || heights[r][c] < heights[i][j]){
                continue;
            }

            dfs(r,c,ocean,heights);
        }
    }

    
}
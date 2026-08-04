class Solution {
    int[][] arr;
    int n;
    int m;
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        this.arr = arr;
        n = arr.length;
        m = arr[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] at = new boolean[n][m];

        for(int i = 0 ; i<n ; i++){
            f(i,0,pac);
            f(i,m-1,at);
        }

        for(int i = 0 ; i<m ; i++){
            f(0,i,pac);
            f(n-1,i,at);
        }


        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(pac[i][j] && at[i][j]){
                    ans.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }

        return ans;
    }

    private void f(int i,int j,boolean[][] vis){
        vis[i][j] = true;
        int[] dr = {0,1,-1,0};
        int[] dc = {-1,0,0,1};

        for(int k = 0 ; k<4 ; k++){
            int nr = i + dr[k];
            int nc = j + dc[k];

            if(nr >= 0 && nc >=0 && nr < n && nc <m && !vis[nr][nc]){
                if(arr[nr][nc] >= arr[i][j]){
                    f(nr,nc,vis);
                }
            }
        }
    }
}
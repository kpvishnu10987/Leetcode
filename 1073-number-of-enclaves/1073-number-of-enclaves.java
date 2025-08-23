class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[][] visited = new int[n][m];

        Queue<int[]> q  = new LinkedList<>();
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        for(int i = 0 ; i<n ; i++){
            if(grid[i][0] == 1){
                q.offer(new int[]{i,0});
                visited[i][0] = 1;
            }
            if(grid[i][m-1] == 1){
                visited[i][m-1] = 1;
                q.offer(new int[]{i,m-1});
            }
        }
        for(int i = 0 ; i<m ; i++){
            if(grid[0][i] == 1){
                q.offer(new int[]{0,i});
                visited[0][i] = 1;
            }
            if(grid[n-1][i] == 1){
                q.offer(new int[]{n-1,i});
                visited[n-1][i] = 1;
            }
        }

        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i = 0 ; i<4 ; i++){
                int nr = p[0] + drow[i];
                int nc = p[1] + dcol[i];
                if(nr >= 0 && nr <n && nc >=0 && nc <m && visited[nr][nc] == 0 && grid[nr][nc] == 1){
                    visited[nr][nc] = 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m ; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    cnt++;
                }
            }
        }

    return cnt;
        
    }
}
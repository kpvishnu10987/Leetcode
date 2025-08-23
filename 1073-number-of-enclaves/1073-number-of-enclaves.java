class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
       

        Queue<int[]> q  = new LinkedList<>();
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        for(int i = 0 ; i<n ; i++){
            if(grid[i][0] == 1){
                q.offer(new int[]{i,0});
                grid[i][0] = 0;
            }
            if(grid[i][m-1] == 1){
                grid[i][m-1] = 0;
                q.offer(new int[]{i,m-1});
            }
        }
        for(int i = 0 ; i<m ; i++){
            if(grid[0][i] == 1){
                q.offer(new int[]{0,i});
                grid[0][i] = 0;
            }
            if(grid[n-1][i] == 1){
                q.offer(new int[]{n-1,i});
                grid[n-1][i] = 0;
            }
        }

        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i = 0 ; i<4 ; i++){
                int nr = p[0] + drow[i];
                int nc = p[1] + dcol[i];
                if(nr >= 0 && nr <n && nc >=0 && nc <m &&  grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m ; j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }

    return cnt;
        
    }
}
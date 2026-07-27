class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        if(q.isEmpty()) return -1;
        int time = 0;
        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int k = 0 ; k<size ; k++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for(int i = 0 ; i<4 ; i++){
                    int nr = r + drow[i];
                    int nc = c + dcol[i];

                    if(nr >=0  && nr <n && nc >=0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                        fresh--;
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        if(fresh > 0) return -1;

        return time-1;
    }
}
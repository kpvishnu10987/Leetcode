class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int cnt  = 0;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    cnt++;
                    q.offer(new int[]{i,j});
                    bfs(q,visited,grid);
                }
            }
        }
        return cnt;
    }
    private void bfs(Queue<int[]> q,boolean[][] visited,char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i = 0 ; i<4 ;i++){
                int nr = p[0] + drow[i];
            int nc = p[1] + dcol[i];

            if(nr>=0 && nr<n && nc >=0 && nc <m && !visited[nr][nc]){
                visited[nr][nc] = true;
                if(grid[nr][nc] == '1'){
                    q.offer(new int[]{nr,nc});
                }
            }
            }
        }



    }
}
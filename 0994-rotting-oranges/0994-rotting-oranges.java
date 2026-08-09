class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;
        int rotten = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n ;i++){
            for(int j = 0 ;j<m ;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    rotten++;
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(rotten == 0 && fresh != 0) return -1;
        if(fresh == 0) return 0;
        int drow[] = {0,0,1,-1};
        int dcol[] = {1,-1,0,0};
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(fresh == 0) return time;
            while(size-- > 0){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for(int i = 0 ; i<4 ; i++){
                    int nr = r + drow[i];
                    int nc = c + dcol[i];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                      grid[nr][nc] = 2;
                      fresh--;
                      q.offer(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }

        if(fresh != 0) return -1;
        return time;


    }
}
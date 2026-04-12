class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{grid[0][0],0,0});
        boolean[][] vis = new boolean[n][n];

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int time = cur[0];
            int i = cur[1];
            int j = cur[2];

            if(i == n-1 && j == n-1) return time;

            if(vis[i][j] == true) continue;

            vis[i][j] = true;

            for(int k=0; k<4 ;k++){
                int[] d = dir[k];
                int nr = i+d[0];
                int nc = j+d[1];

                if(nr >=0 && nc >=0 && nr<n && nc < n){
                    pq.offer(new int[]{
                        Math.max(time,grid[nr][nc]),
                        nr,
                        nc
                    });
                }
            }
        }
        return 0;
    }
}
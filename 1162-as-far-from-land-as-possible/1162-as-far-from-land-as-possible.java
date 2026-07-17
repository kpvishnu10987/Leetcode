class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] h = new int[n][m];
        for(int[] r : h){
            Arrays.fill(r,-1);
        }
        boolean water = false;
        boolean land = false;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == 1){
                    h[i][j] = 0;
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                    land = true;
                }else if(grid[i][j] == 0){
                    water = true;
                }
            }
        }

        if(!water || !land) return -1;
        int[] drow = {0,1,0,-1};
        int max = 0;
        int[] dcol = {1,0,-1,0};

        while(!q.isEmpty()){
            int z = q.size();
            for(int i = 0 ; i<z ; i++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for(int k = 0 ; k<4 ; k++){
                    int nr = r + drow[k];
                    int nc = c + dcol[k];

                    if(nr >=0 && nc >= 0 && nr <n && nc <m && vis[nr][nc] == false){
                        vis[nr][nc] = true;
                        h[nr][nc] = h[r][c] + 1;
                        max = Math.max(max,h[nr][nc]);
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return max;
    }
}
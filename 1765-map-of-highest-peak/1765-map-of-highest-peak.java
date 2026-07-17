class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] h = new int[n][m];
        for(int[] r : h){
            Arrays.fill(r,-1);
        }
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(isWater[i][j] == 1){
                    h[i][j] = 0;
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        int[] drow = {0,1,0,-1};
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
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return h;
    }
}
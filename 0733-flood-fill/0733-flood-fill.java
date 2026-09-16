class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        int m = image[0].length;

        int or = image[sr][sc];
        boolean[][] vis = new boolean[n][m];

        image[sr][sc] = color;
        vis[sr][sc] = true;
        int dr[] ={0,0,1,-1};
        int dc[] ={1,-1,0,0};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for(int k = 0 ; k<4 ; k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if(nr >=0 && nr < n && nc >=0 && nc <m && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        if(image[nr][nc] == or){
                            image[nr][nc] = color;
                            q.offer(new int[]{nr,nc});
                        }
                    }

                }
            }
        }

        return image;
    }
}
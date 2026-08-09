class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int ori = image[sr][sc];
        if(color == ori) return image;
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = color;
        q.offer(new int[]{sr,sc});

        int[] drow = {0,0,1,-1};
        int[] dcol = {1,-1,0,0};

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int i = 0 ; i<4 ;i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if(nr >= 0&& nc >=0 && nr < n&& nc <m && image[nr][nc] == ori){
                    image[nr][nc] = color;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        return image;
    }
}